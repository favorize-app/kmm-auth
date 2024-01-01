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
import multi.platform.auth.shared.external.constants.AuthKey
import multi.platform.core.shared.app.common.CoreDialogFragment
import multi.platform.core.shared.external.constants.CommonKey
import multi.platform.core.shared.external.extensions.goTo
import multi.platform.core.shared.external.extensions.launchAndCollectIn
import multi.platform.core.shared.external.extensions.showErrorSnackbar
import multi.platform.core.shared.external.utilities.Persistent
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject

class ForgetPasswordDialogFragment : CoreDialogFragment() {
    private val forgetPasswordViewModel: ForgetPasswordViewModel by viewModel()
    private val persistent: Persistent by inject()
    private val authConfig: AuthConfig by inject()

    private lateinit var binding: ForgetPasswordDialogFragmentBinding

    override fun isCancelable() = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        getString(R.string.route_auth_error_connection_full).replace(
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
