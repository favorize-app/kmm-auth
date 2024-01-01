package multi.platform.auth.shared.app.signoutdialog

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
import com.onesignal.OneSignal
import multi.platform.auth.shared.BuildConfig
import multi.platform.auth.shared.R
import multi.platform.auth.shared.databinding.SignoutDialogFragmentBinding
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

class SignOutDialogFragment : CoreDialogFragment() {
    private val signOutViewModel: SignOutViewModel by viewModel()
    private val persistent: Persistent by inject()
    private val authConfig: AuthConfig by inject()

    private lateinit var binding: SignoutDialogFragmentBinding

    override fun isCancelable() = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(CommonKey.RETRY_KEY) { _, b ->
            if (b.getString(CommonKey.RETRY_KEY, "") == AuthKey.SIGN_IN_KEY) {
                Handler(Looper.getMainLooper()).postDelayed({ signOutViewModel.signOut() }, 300)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.signout_dialog_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
    }

    private fun setupObserver() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = signOutViewModel.also {
            it.onSignOut.launchAndCollectIn(this, Lifecycle.State.STARTED) { ok ->
                onSignOut(ok)
                it.onSignOut.value = false
            }
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
            it.onCancel.launchAndCollectIn(this, Lifecycle.State.STARTED) { nok ->
                onCancel(nok)
                it.onCancel.value = false
            }
            it.forceSignout.launchAndCollectIn(this, Lifecycle.State.STARTED) { nok ->
                onSignOut(nok)
                it.forceSignout.value = false
            }
            it.onException.launchAndCollectIn(this, Lifecycle.State.STARTED) { e ->
                e?.let {
                    goTo(
                        getString(R.string.route_auth_error_connection_full).replace(
                            "{key}",
                            AuthKey.SIGN_OUT_KEY,
                        ),
                    )
                }
                it.onException.value = null
            }
        }
    }

    private fun setupView() {
        binding.mbSignoutYes.setOnClickListener {
            if (authConfig.signOutApi.isNotEmpty()) {
                signOutViewModel.signOut()
            } else signOutViewModel.onSignOut.value = true
        }
    }

    private fun onSignOut(ok: Boolean) {
        if (ok) {
            persistent.remove(CommonKey.ACCESS_TOKEN_KEY)
            persistent.remove(CommonKey.REFRESH_TOKEN_KEY)
            if (BuildConfig.ONESIGNAL_APP_ID.isNotEmpty()) {
                OneSignal.logout()
            }
            setFragmentResult(AuthKey.SIGN_OUT_KEY, bundleOf(AuthKey.SIGN_OUT_KEY to true))
            dismiss()
        }
    }

    private fun onCancel(ok: Boolean) {
        if (ok) dismiss()
    }
}
