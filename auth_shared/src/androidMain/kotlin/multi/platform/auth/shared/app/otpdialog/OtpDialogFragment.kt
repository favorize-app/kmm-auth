package multi.platform.auth.shared.app.otpdialog

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.color.MaterialColors
import multi.platform.auth.shared.R
import multi.platform.auth.shared.databinding.OtpDialogFragmentBinding
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.ApiConfig
import multi.platform.auth.shared.external.UiConfig
import multi.platform.auth.shared.external.FeatureConfig
import multi.platform.auth.shared.external.constants.AuthKey
import androidx.fragment.app.DialogFragment
import multi.platform.auth.shared.utils.CommonKey
import multi.platform.auth.shared.utils.goTo
import multi.platform.auth.shared.utils.launchAndCollectIn
import multi.platform.auth.shared.utils.showErrorSnackbar
import multi.platform.auth.shared.utils.showKeyboard
import multi.platform.auth.shared.utils.showToast
import multi.platform.auth.shared.utils.Persistent
class OtpDialogFragment : DialogFragment() {
    private lateinit var persistent: Persistent
    private lateinit var otpViewModel: OtpViewModel
    private lateinit var authConfig: AuthConfig

    private var mCountDownTimer: CountDownTimer? = null
    private lateinit var binding: OtpDialogFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = false
        
        // Initialize dependencies
        persistent = Persistent(requireContext())
        otpViewModel = OtpViewModel()
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
            if (b.getString(CommonKey.RETRY_KEY, "") == AuthKey.OTP_KEY) {
                Handler(Looper.getMainLooper()).postDelayed({ submit() }, 300)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.otp_dialog_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        setupView()
        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) showKeyboard(binding.etOtp1)
        }, 300)
    }

    private fun setupObserver() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = otpViewModel.also {
            arguments?.let { a ->
                it.state.value = a.getString("state")
                it.country.value = a.getString("country")
                it.phone.value = a.getString("phone")
                otpViewModel.transactionId.value = a.getString("transactionId")
                val duration = a.getString("duration")
                duration?.let { d -> startCountDownTimer(d.toLong()) }
            }
            it.otpResend.value = getString(R.string.otp_please_wait)
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
            it.toastMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showToast(m)
                it.toastMessage.value = null
            }
            it.onSignedIn.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                onSignedIn(t)
                it.onSignedIn.value = null
            }
            it.onResendOtp.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                onResendOtp(t)
                it.onResendOtp.value = null
            }
            it.onOTPVerifyRegister.launchAndCollectIn(this, Lifecycle.State.STARTED) { ok ->
                onOTPVerifyRegister(ok)
                it.onOTPVerifyRegister.value = null
            }
            it.onException.launchAndCollectIn(this, Lifecycle.State.STARTED) { e ->
                e?.let {
                    goTo(
                        getString(authConfig.routeErrorConnection).replace(
                            "{key}",
                            AuthKey.OTP_KEY,
                        ),
                    )
                }
                it.onException.value = null
            }
        }
    }

    private fun setupView() {
        binding.etOtp1.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, binding.etOtp2))
            setOnKeyListener(OtpKeyEvent(this, null))
        }
        binding.etOtp2.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, binding.etOtp3))
            setOnKeyListener(OtpKeyEvent(this, binding.etOtp1))
        }
        binding.etOtp3.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, binding.etOtp4))
            setOnKeyListener(OtpKeyEvent(this, binding.etOtp2))
        }
        binding.etOtp4.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, binding.etOtp5))
            setOnKeyListener(OtpKeyEvent(this, binding.etOtp3))
        }
        binding.etOtp5.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, binding.etOtp6))
            setOnKeyListener(OtpKeyEvent(this, binding.etOtp4))
        }
        binding.etOtp6.apply {
            addTextChangedListener(OtpTextWatcher(binding.tvOtpError, this, null))
            setOnKeyListener(OtpKeyEvent(this, binding.etOtp5))
        }

        binding.btnSubmit.setOnClickListener { submit() }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountDownTimer?.cancel()
    }

    private fun submit() {
        if (!validate()) return
        val otp =
            otpViewModel.otp1.value + otpViewModel.otp2.value + otpViewModel.otp3.value + otpViewModel.otp4.value + otpViewModel.otp5.value + otpViewModel.otp6.value
        otpViewModel.verifyOtp(otp)
    }

    private fun validate(): Boolean {
        var result = true
        if (otpViewModel.otp1.value == null || otpViewModel.otp1.value.isNullOrEmpty() ||
            otpViewModel.otp2.value == null || otpViewModel.otp2.value.isNullOrEmpty() ||
            otpViewModel.otp3.value == null || otpViewModel.otp3.value.isNullOrEmpty() ||
            otpViewModel.otp4.value == null || otpViewModel.otp4.value.isNullOrEmpty() ||
            otpViewModel.otp5.value == null || otpViewModel.otp5.value.isNullOrEmpty() ||
            otpViewModel.otp6.value == null || otpViewModel.otp6.value.isNullOrEmpty()
        ) {
            result = false
        }
        val bg =
            if (result) R.drawable.bg_round8_stroke_normal else R.drawable.bg_round8_stroke_error
        binding.etOtp1.background =
            ContextCompat.getDrawable(requireContext(), bg)
        binding.etOtp2.background =
            ContextCompat.getDrawable(requireContext(), bg)
        binding.etOtp3.background =
            ContextCompat.getDrawable(requireContext(), bg)
        binding.etOtp4.background =
            ContextCompat.getDrawable(requireContext(), bg)
        binding.etOtp5.background =
            ContextCompat.getDrawable(requireContext(), bg)
        binding.etOtp6.background =
            ContextCompat.getDrawable(requireContext(), bg)

        return result
    }

    private fun onSignedIn(ticket: Ticket?) {
        ticket?.let {
            it.session?.token?.let { t -> persistent.putString(CommonKey.ACCESS_TOKEN_KEY, t) }
            it.session?.refreshToken?.let { r -> persistent.putString(CommonKey.REFRESH_TOKEN_KEY, r) }
            it.session?.msisdn?.let { m -> persistent.putString(CommonKey.PHONE_KEY, m) }
            setFragmentResult(AuthKey.SIGN_IN_KEY, bundleOf(AuthKey.SIGN_IN_KEY to true))
            findNavController().navigateUp()
        }
    }

    private fun onOTPVerifyRegister(ticket: Ticket?) {
        ticket?.let {
            setFragmentResult(
                AuthKey.VERIFY_KEY,
                bundleOf(
                    AuthKey.COUNTRY_KEY to otpViewModel.country.value.toString(),
                    CommonKey.PHONE_KEY to otpViewModel.phone.value.toString(),
                    AuthKey.TRANSACTION_ID to it.transactionId,
                ),
            )
        }
    }

    private class OtpKeyEvent(
        private val currentView: EditText,
        private val previousView: EditText?,
    ) : View.OnKeyListener {
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event?.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.et_otp1 && currentView.text.isEmpty()) {
                previousView?.text = null
                previousView?.requestFocus()
                return true
            }
            return false
        }
    }

    @Suppress("kotlin:S1186")
    private class OtpTextWatcher(
        private val tvOtpError: View,
        private val currentView: View,
        private val nextView: View?,
    ) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            val text = editable.toString()
            currentView.setBackgroundResource(R.drawable.bg_round8_stroke_normal)
            tvOtpError.isVisible = false
            when (currentView.id) {
                R.id.et_otp1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp3 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp4 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.et_otp5 -> if (text.length == 1) nextView!!.requestFocus()
            }
        }

        override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
        override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
    }

    private fun startCountDownTimer(duration: Long) {
        mCountDownTimer = object : CountDownTimer(duration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val s = (millisUntilFinished / 1000)
                val minutesLeft = String.format("%d", s / 60)
                val secondsLeft = String.format("%d", s % 60)
                otpViewModel.time.value = "$minutesLeft:$secondsLeft"
            }

            override fun onFinish() {
                otpViewModel.time.value = null
                otpViewModel.otpResend.value = getString(R.string.otp_resend)
                binding.tvOtpResend.apply {
                    setTextColor(
                        ContextCompat.getColor(requireContext(), android.R.color.holo_blue_dark),
                    )
                    setOnClickListener { otpViewModel.resendOtp() }
                }
            }
        }.start()
    }

    private fun onResendOtp(ticket: Ticket?) {
        ticket?.let {
            otpViewModel.transactionId.value = it.transactionId
            otpViewModel.otpResend.value = getString(R.string.otp_please_wait)
            binding.tvOtpResend.apply {
                setTextColor(
                    MaterialColors.getColor(
                        requireContext(),
                        android.R.attr.colorPrimary,
                        ContextCompat.getColor(requireContext(), android.R.color.holo_blue_dark),
                    ),
                )
                setOnClickListener(null)
            }
            it.otp?.duration?.let { d -> startCountDownTimer(d) }
        }
    }
}
