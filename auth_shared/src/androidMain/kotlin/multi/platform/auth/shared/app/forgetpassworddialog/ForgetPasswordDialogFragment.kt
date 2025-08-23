package multi.platform.auth.shared.app.forgetpassworddialog

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import multi.platform.auth.shared.R
import multi.platform.auth.shared.databinding.ForgetPasswordDialogFragmentBinding
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.ApiConfig
import multi.platform.auth.shared.external.UiConfig
import multi.platform.auth.shared.external.FeatureConfig
import multi.platform.auth.shared.external.constants.AuthKey
import multi.platform.auth.shared.domain.auth.usecase.ForgetPasswordUseCase
import androidx.fragment.app.DialogFragment
import multi.platform.auth.shared.utils.CommonKey
import multi.platform.auth.shared.utils.goTo
import multi.platform.auth.shared.utils.launchAndCollectIn
import multi.platform.auth.shared.utils.showErrorSnackbar
import multi.platform.auth.shared.utils.Persistent

class ForgetPasswordDialogFragment : DialogFragment() {
    private lateinit var forgetPasswordViewModel: ForgetPasswordViewModel
    private lateinit var persistent: Persistent
    private lateinit var authConfig: AuthConfig

    private lateinit var binding: ForgetPasswordDialogFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        
        // Initialize dependencies
        forgetPasswordViewModel = ForgetPasswordViewModel(object : ForgetPasswordUseCase {
            override suspend fun invoke(email: String): String = "stub"
        })
        persistent = Persistent(requireContext())
        authConfig = object : AuthConfig {
            override val api = object : ApiConfig {
                override val baseUrl = "https://api.example.com"
                override val timeout = 30000L
            }
            override val ui = object : UiConfig {
                override val primaryColor = "#000000"
                override val logo = "logo"
            }
            override val features = object : FeatureConfig {
                override val enableBiometric = false
                override val enableSocialLogin = false
            }
        }
        setFragmentResultListener(CommonKey.RETRY_KEY) { _, b ->
            if (b.getString(CommonKey.RETRY_KEY, "") == AuthKey.FORGET_PASSWORD_KEY) {
                Handler(Looper.getMainLooper()).postDelayed(
                    { forgetPasswordViewModel.submit() },
                    300,
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.forget_password_dialog_fragment,
            container,
            false,
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
    }

    private fun setupObserver() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = forgetPasswordViewModel.also {
            it.accessToken = persistent.getString(CommonKey.ACCESS_TOKEN_KEY, null)
            it.loadingIndicator.launchAndCollectIn(this, Lifecycle.State.STARTED) { l ->
                l?.let {
                    binding.loadingView.clLoading.isVisible = l
                    binding.loadingView.cpiLoading.isVisible = l
                }
                it.loadingIndicator.value = null
            }
            it.errorMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showErrorSnackbar(requireActivity().findViewById(authConfig.rootView), m)
                it.errorMessage.value = null
            }
            it.onException.launchAndCollectIn(this, Lifecycle.State.STARTED) { e ->
                e?.let {
                    goTo(
                        getString(authConfig.routeErrorConnection).replace(
                            "{key}",
                            AuthKey.FORGET_PASSWORD_KEY,
                        ),
                    )
                }
                it.onException.value = null
            }
            it.onSubmit.launchAndCollectIn(this, Lifecycle.State.STARTED) { ok ->
                onSubmit(ok)
                it.onSubmit.value = false
            }
        }
    }

    private fun setupView() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }

    private fun onSubmit(ok: Boolean) {
        if (ok) {
            setFragmentResult(
                AuthKey.FORGET_PASSWORD_KEY,
                bundleOf(AuthKey.FORGET_PASSWORD_KEY to true),
            )
            dismiss()
        }
    }
}
