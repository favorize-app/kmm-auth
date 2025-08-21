package multi.platform.auth.shared.external.utilities

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyPermanentlyInvalidatedException
import android.security.keystore.KeyProperties
import android.util.Base64
import androidx.annotation.Keep
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import multi.platform.auth.shared.R
import timber.log.Timber
import java.io.IOException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException
import java.security.UnrecoverableKeyException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.security.cert.CertificateException

@Keep
class BiometricUtil(
    private val context: Context,
    androidKeyStore: String,
    private val onAuthenticationSucceeded: (String) -> Unit,
) {
    private var keyStore: KeyStore
    private var keyGenerator: KeyGenerator

    init {
        try {
            keyStore = KeyStore.getInstance(androidKeyStore)
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to get an instance of KeyStore", e)
        }

        try {
            keyGenerator =
                KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, androidKeyStore)
        } catch (e: Exception) {
            when (e) {
                is NoSuchAlgorithmException,
                is NoSuchProviderException,
                ->
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
                is IOException,
                -> throw RuntimeException(e)

                else -> throw e
            }
        }

        try {
            keyStore = KeyStore.getInstance(androidKeyStore)
        } catch (e: KeyStoreException) {
            throw RuntimeException("Failed to get an instance of KeyStore", e)
        }

        try {
            keyGenerator =
                KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, androidKeyStore)
        } catch (e: Exception) {
            when (e) {
                is NoSuchAlgorithmException,
                is NoSuchProviderException,
                ->
                    throw RuntimeException("Failed to get an instance of KeyGenerator", e)

                else -> throw e
            }
        }
    }

    private fun setupCipher(cipher: Cipher, keyName: String): Boolean {
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
                is InvalidKeyException,
                -> throw RuntimeException("Failed to init Cipher", e)

                else -> throw e
            }
        }
    }

    fun show() {
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(context.getString(R.string.signin_finger_title))
            .setDescription(context.getString(R.string.signin_finger_description))
            .setConfirmationRequired(false)
            .setNegativeButtonText(context.getString(R.string.signin_finger_use_app_password))
            .build()
        val cipherString =
            "${KeyProperties.KEY_ALGORITHM_AES}/${KeyProperties.BLOCK_MODE_CBC}/${KeyProperties.ENCRYPTION_PADDING_PKCS7}"
        val cipher = Cipher.getInstance(cipherString)
        if (setupCipher(cipher, "default_key")) {
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
                            val encryptedString = Base64.encodeToString(encrypted, 0)
                            onAuthenticationSucceeded.invoke(encryptedString)
                        } catch (e: Exception) {
                            when (e) {
                                is BadPaddingException,
                                is IllegalBlockSizeException,
                                -> {
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
}
