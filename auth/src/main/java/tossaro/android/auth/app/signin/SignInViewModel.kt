package tossaro.android.auth.app.signin

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.security.keystore.KeyProperties
import android.util.Base64
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.coroutines.launch
import timber.log.Timber
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.R
import tossaro.android.auth.domain.user.usecase.CheckPhoneUseCase
import tossaro.android.auth.domain.user.usecase.SignInEmailUseCase
import tossaro.android.auth.domain.user.usecase.SignInProviderUseCase
import tossaro.android.core.app.BaseViewModel
import tossaro.android.core.data.network.response.ApiResponse
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.domain.entity.Token
import tossaro.android.core.external.constant.AppConstant
import tossaro.android.core.external.utility.ValidationUtil
import java.io.IOException
import java.security.*
import javax.crypto.*
import javax.security.cert.CertificateException

class SignInViewModel(
    private val checkPhoneUseCase: CheckPhoneUseCase,
    private val signInEmailUseCase: SignInEmailUseCase,
    private val signInProviderUseCase: SignInProviderUseCase,
) : BaseViewModel() {
    private lateinit var keyStore: KeyStore
    private lateinit var keyGenerator: KeyGenerator
    private val ANDROID_KEY_STORE = "AndroidKeyStore"
    val onCheckPhone = MutableLiveData<Ticket>()
    val signInType = MutableLiveData<String>()
    val country = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val phoneError = MutableLiveData<Int?>()
    val email = MutableLiveData<String>()
    val emailError = MutableLiveData<Int?>()
    val password = MutableLiveData<String>()
    val passwordError = MutableLiveData<Int?>()
    val signInByGoogleTrigger = MutableLiveData<Boolean>()
    val signInByFacebookTrigger = MutableLiveData<Boolean>()

    init {
        signInType.value = "phone"
    }

    fun toggleEmailForm() {
        signInType.value = if (signInType.value.equals("phone")) "email" else "phone"
    }

    fun signInByGoogle(context: Context) {
        loadingIndicator.value = true
        val account = GoogleSignIn.getLastSignedInAccount(context)
        account?.let {
            onGetAccessToken("google", it.idToken.toString())
        } ?: run {
            loadingIndicator.value = false
            signInByGoogleTrigger.value = true
        }
    }

    fun signInByFacebook() {
        loadingIndicator.value = false
        signInByFacebookTrigger.value = true
    }

    fun onGetAccessTokenFail(error: String?) {
        loadingIndicator.value = false
        alertMessage.value = error
    }

    fun goToForgotPassword() {
        alertMessage.value = "Forgot Password Screen"
    }

    fun goToRegister() {
        alertMessage.value = "Register Screen"
    }

    fun saveTokenLocal(apiResponse: ApiResponse<Token>) = viewModelScope.launch {
        sharedPrefs.value?.edit()
            ?.putString(AppConstant.ACCESS_TOKEN, apiResponse.data.token)
            ?.putString(AppConstant.REFRESH_TOKEN, apiResponse.data.refresh_token)
            ?.apply()
        loadingIndicator.value = false
        alertMessage.value = apiResponse.meta.message
        onSignedIn.value = AuthRouters.HOME
    }

    fun phoneValidate(defaultCountryCode: String?) {
        val error = when {
            !ValidationUtil.minCharacter(
                8,
                phone.value
            ) && country.value == defaultCountryCode -> R.string.sign_in_phone_error_min_character
            !ValidationUtil.phoneFormat(
                country.value,
                phone.value
            ) -> R.string.sign_in_phone_error_format
            else -> null
        }
        phoneError.postValue(error)
    }

    fun signInPhone() {
        if (phone.value.isNullOrEmpty() || phoneError.value != null) return
        onCheckPhone.value = Ticket("ticketId", 300, 2) // remove this line when integration to api
//        viewModelScope.launch { // uncomment block when integration to api
//            loadingIndicator.value = true
//            when (val response = checkPhoneUseCase(phoneString.value.toString())) {
//                is NetworkResponse.Success -> {
//                    response.body.data.let { u ->
//                        onCheckPhone.value = u.token
//                    }
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.body?.message.orEmpty()
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.error.message.orEmpty()
//                }
//            }
//        }
    }

    fun emailValidate() {
        val error = when {
            ValidationUtil.notBlank(email.value) == false -> R.string.sign_in_email_error_empty
            ValidationUtil.emailFormat(email.value) == false -> R.string.sign_in_email_error_format
            else -> null
        }
        emailError.postValue(error)
    }

    fun passwordValidate() {
        val error = when {
            !ValidationUtil.minCharacter(
                8,
                password.value
            ) -> R.string.sign_in_password_error_min_character
            else -> null
        }
        passwordError.postValue(error)
    }

    fun signInEmail() {
        if (email.value.isNullOrEmpty() || password.value.isNullOrEmpty()) return
        alertMessage.value = "Sign in with email and password" // remove when integration to api
//        viewModelScope.launch { // uncomment block when integration to api
//            loadingIndicator.value = true
//            when (val response = signInEmailUseCase(email.value.toString(), password.value.toString())) {
//                is NetworkResponse.Success -> {
//                    saveTokenLocal(response.body)
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.body?.message.orEmpty()
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.error.message.orEmpty()
//                }
//            }
//        }
    }

    fun onGetAccessToken(provider: String, accessToken: String) {
//        viewModelScope.launch {
//            when (val response = signInProviderUseCase(provider, accessToken)) {
//                is NetworkResponse.Success -> {
//                    saveTokenLocal(response.body)
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.body?.meta?.message
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.error.message.orEmpty()
//                }
//            }
//        }
    }

    private fun initialFingerPrint() {
        try {
            keyStore = KeyStore.getInstance(ANDROID_KEY_STORE)
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to get an instance of KeyStore", e)
        }

        try {
            keyGenerator =
                KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEY_STORE)
        } catch (e: Exception) {
            when (e) {
                is NoSuchAlgorithmException,
                is NoSuchProviderException ->
                    throw RuntimeException("Failed to get an instance of KeyGenerator", e)
                else -> throw e
            }
        }

        try {
            keyStore.load(null)

            val keyProperties = KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            val builder = KeyGenParameterSpec.Builder("default_key", keyProperties)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setUserAuthenticationRequired(true)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)

            keyGenerator.run {
                init(builder.build())
                generateKey()
            }
        } catch (e: Exception) {
            when (e) {
                is NoSuchAlgorithmException,
                is InvalidAlgorithmParameterException,
                is CertificateException,
                is IOException -> throw RuntimeException(e)
                else -> throw e
            }
        }

        try {
            keyStore = KeyStore.getInstance(ANDROID_KEY_STORE)
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to get an instance of KeyStore", e)
        }

        try {
            keyGenerator =
                KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEY_STORE)
        } catch (e: Exception) {
            when (e) {
                is NoSuchAlgorithmException,
                is NoSuchProviderException ->
                    throw RuntimeException("Failed to get an instance of KeyGenerator", e)
                else -> throw e
            }
        }
    }

    fun signInFingerprint(context: Context) {
        initialFingerPrint()
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(context.getString(R.string.sign_in_finger_title))
            .setDescription(context.getString(R.string.sign_in_finger_description))
            .setConfirmationRequired(false)
            .setNegativeButtonText(context.getString(R.string.sign_in_finger_use_app_password))
            .build()
        val cipherString =
            "${KeyProperties.KEY_ALGORITHM_AES}/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}"
        val cipher = Cipher.getInstance(cipherString)
        if (initCipher(cipher, "default_key")) {
            val executor = ContextCompat.getMainExecutor(context)
            val callback = object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Timber.e("$errorCode :: $errString")
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Timber.e("Authentication failed for an unknown reason")
                }

                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    Timber.d("Authentication was successful")
                    result.cryptoObject?.cipher?.let {
                        try {
                            val encrypted = it.doFinal("Very secret message".toByteArray())
                            val encryptedString = Base64.encodeToString(encrypted, 0 /* flags */)
                            onGetAccessToken("biometric", encryptedString)
                        } catch (e: Exception) {
                            when (e) {
                                is BadPaddingException,
                                is IllegalBlockSizeException -> {
                                    Timber.e("Failed to encrypt the data with the generated key. ${e.message}")
                                }
                                else -> throw e
                            }
                        }
                    }
                }
            }

            val biometricPrompt = BiometricPrompt(context as FragmentActivity, executor, callback)
            biometricPrompt.authenticate(promptInfo, BiometricPrompt.CryptoObject(cipher))
        }
    }

    private fun initCipher(cipher: Cipher, keyName: String): Boolean {
        try {
            keyStore.load(null)
            cipher.init(Cipher.ENCRYPT_MODE, keyStore.getKey(keyName, null) as SecretKey)
            return true
        } catch (e: Exception) {
            when (e) {
                is KeyPermanentlyInvalidatedException -> return false
                is KeyStoreException,
                is CertificateException,
                is UnrecoverableKeyException,
                is IOException,
                is NoSuchAlgorithmException,
                is InvalidKeyException -> throw RuntimeException("Failed to init Cipher", e)
                else -> throw e
            }
        }
    }
}