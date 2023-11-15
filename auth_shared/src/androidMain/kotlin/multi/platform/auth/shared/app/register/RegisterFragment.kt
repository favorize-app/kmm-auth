package multi.platform.auth.shared.app.register

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import multi.platform.auth.shared.R
import multi.platform.auth.shared.databinding.RegisterFragmentBinding
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.constants.AuthKey
import multi.platform.core.shared.app.common.CoreFragment
import multi.platform.core.shared.external.constants.CommonKey
import multi.platform.core.shared.external.extensions.getPathFromURI
import multi.platform.core.shared.external.extensions.goTo
import multi.platform.core.shared.external.extensions.launchAndCollectIn
import multi.platform.core.shared.external.extensions.showErrorSnackbar
import multi.platform.core.shared.external.extensions.showKeyboard
import multi.platform.core.shared.external.extensions.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject
import java.io.File
import multi.platform.core.shared.R as cR

class RegisterFragment : CoreFragment() {
    private val minChar = 9
    private val authConfig: AuthConfig by inject()
    private val registerViewModel: RegisterViewModel by viewModel()
    private val sharedPreferences: SharedPreferences by inject()
    private lateinit var binding: RegisterFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(CommonKey.RETRY_KEY) { _, b ->
            if (b.getString(CommonKey.RETRY_KEY, "") == AuthKey.REGISTER_KEY) {
                Handler(Looper.getMainLooper()).postDelayed({ submit() }, 300)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
        Handler(Looper.getMainLooper()).postDelayed({
            showKeyboard(binding.etName)
        }, 300)
    }

    private fun setupObserver() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = registerViewModel.also {
            arguments?.let { a ->
                it.country.value = a.getString("country")
                it.phone.value = if (a.getString("phone") != "{phone}") a.getString("phone") else ""
                it.transactionId = a.getString("transactionId").toString()
                it.requirePassword.value = it.phone.value?.isEmpty() == true
            }
            it.errorMinChar = getString(cR.string.error_min_character, minChar)
            it.errorEmptyField = getString(cR.string.error_empty_field)
            it.errorEmailFormat = getString(cR.string.error_email_format)
            it.errorPasswordFormat = getString(R.string.error_password_format)
            it.errorPasswordConfirm = getString(R.string.error_password_confirm)
            it.loadingIndicator.launchAndCollectIn(this, Lifecycle.State.STARTED) { l ->
                l?.let {
                    binding.loadingView.clLoading.isVisible = l
                    binding.loadingView.lpiLoading.isVisible = l
                }
                it.loadingIndicator.value = null
            }
            it.errorMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showErrorSnackbar(binding.root, m)
                it.errorMessage.value = null
            }
            it.toastMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showToast(m)
                it.toastMessage.value = null
            }
            it.onSignedIn.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                onSignedIn(t)
                it.onSignedIn.value = null
            }
            it.onException.launchAndCollectIn(this, Lifecycle.State.STARTED) { e ->
                e?.let {
                    goTo(
                        getString(R.string.route_auth_error_connection_full).replace(
                            "{key}",
                            AuthKey.REGISTER_KEY,
                        ),
                    )
                }
                it.onException.value = null
            }
            it.name.launchAndCollectIn(this, Lifecycle.State.STARTED) { _ ->
                it.validateBlank(it.name, it.nameError)
            }
            it.bio.launchAndCollectIn(this, Lifecycle.State.STARTED) { _ ->
                it.validateBlank(it.bio, it.bioError)
            }
            it.email.launchAndCollectIn(this, Lifecycle.State.STARTED) { _ ->
                it.validateEmailFormat(it.email, it.emailError)
            }
            it.password.launchAndCollectIn(this, Lifecycle.State.STARTED) { _ ->
                it.validatePassword()
            }
            it.passwordConfirm.launchAndCollectIn(this, Lifecycle.State.STARTED) { _ ->
                it.validatePasswordConfirm()
            }
        }
    }

    private fun setupView() {
        binding.ivAvatar.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startForResultFromGallery.launch(intent)
        }
        binding.addAvatar.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startForResultFromGallery.launch(intent)
        }
        binding.etCountry.setCompoundDrawablesRelativeWithIntrinsicBounds(
            authConfig.countryFlag,
            0,
            0,
            0,
        )
        binding.etPhone.apply {
            doAfterTextChanged {
                registerViewModel.validatePhoneFormat(
                    registerViewModel.phone,
                    registerViewModel.phoneError,
                )
                registerViewModel.validateMinChar(
                    minChar,
                    registerViewModel.phone,
                    registerViewModel.phoneError,
                )
            }
            doOnTextChanged { text, _, _, _ ->
                if (registerViewModel.country.value == getString(R.string.country_codes_default_code) && text.toString() == "0") {
                    binding.etPhone.setText("")
                }
            }
        }
        binding.clPassword.isVisible = registerViewModel.requirePassword.value
        binding.mbRegister.setOnClickListener { submit() }
    }

    private fun submit() {
        var file: File? = null
        registerViewModel.picturePath.value?.let { file = File(it) }
        registerViewModel.register(file?.readBytes(), file?.name)
    }

    private fun onSignedIn(ticket: Ticket?) {
        ticket?.let {
            sharedPreferences.edit()
                .putString(CommonKey.ACCESS_TOKEN_KEY, it.session?.token)
                .putString(CommonKey.REFRESH_TOKEN_KEY, it.session?.refreshToken)
                .putString(CommonKey.PHONE_KEY, it.session?.msisdn)
                .apply()
            setFragmentResult(
                AuthKey.SIGN_IN_KEY,
                bundleOf(AuthKey.SIGN_IN_KEY to true),
            )
            findNavController().navigateUp()
        }
    }

    private val startForResultFromGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                try {
                    if (result.data != null) {
                        val selectedImageUri = result.data?.data
                        selectedImageUri?.let {
                            registerViewModel.picturePath.value = getPathFromURI(it)
                            val bitmap = BitmapFactory.decodeStream(
                                requireContext().contentResolver.openInputStream(it),
                            )
                            binding.ivAvatar.setImageBitmap(bitmap)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
}
