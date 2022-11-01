package multi.platform.auth.app.otp

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import multi.platform.auth.R
import multi.platform.auth.databinding.OtpDialogFragmentBinding
import multi.platform.auth.shared.app.otp.OtpDialogViewModel
import multi.platform.auth.shared.external.constant.AuthConstant
import multi.platform.core.shared.app.common.BaseDialogFragment
import multi.platform.core.shared.domain.common.entity.Ticket
import multi.platform.core.shared.external.constant.AppConstant
import multi.platform.core.shared.external.extension.showErrorSnackbar
import multi.platform.core.shared.external.extension.showKeyboard
import multi.platform.core.shared.external.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import multi.platform.core.shared.R as cR


class OtpDialogFragment : BaseDialogFragment<OtpDialogFragmentBinding>(
    R.layout.otp_dialog_fragment
) {

    private val vm: OtpDialogViewModel by viewModel()
    private var mCountDownTimer: CountDownTimer? = null

    override fun isCancelable() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(AuthConstant.REGISTER_REQ) { _, b ->
            if (b.getBoolean(AuthConstant.REGISTER_REQ)) {
                setFragmentResult(
                    AuthConstant.SIGN_IN_REQ,
                    bundleOf(AuthConstant.SIGN_IN_REQ to true)
                )
                findNavController().navigateUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm.also {
            it.otpResend.value = getString(R.string.otp_please_wait)
        }
        val scope = viewLifecycleOwner.lifecycleScope
        scope.launchWhenResumed { vm.loadingIndicator.collect { l -> l?.let { showFullLoading(l) } } }
        scope.launchWhenResumed { vm.errorMessage.collect { showErrorSnackbar(it) } }
        scope.launchWhenResumed { vm.toastMessage.collect { showToast(it) } }
        scope.launchWhenResumed { vm.onSignedIn.collect { onSignedIn(it) } }
        scope.launchWhenResumed { vm.onResendOtp.collect { onResendOtp(it) } }
        scope.launchWhenResumed { vm.onOTPVerifyRegister.collect { onOTPVerifyRegister(it) } }

        binding.apply {
            etOtp1.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp1,
                    etOtp2
                )
            )
            etOtp2.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp2,
                    etOtp3
                )
            )
            etOtp3.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp3,
                    etOtp4
                )
            )
            etOtp4.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp4,
                    etOtp5
                )
            )
            etOtp5.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp5,
                    etOtp6
                )
            )
            etOtp6.addTextChangedListener(
                OtpTextWatcher(
                    binding.tvOtpError,
                    etOtp6,
                    null
                )
            )

            etOtp1.setOnKeyListener(
                OtpKeyEvent(
                    etOtp1,
                    null
                )
            )
            etOtp2.setOnKeyListener(
                OtpKeyEvent(
                    etOtp2,
                    etOtp1
                )
            )
            etOtp3.setOnKeyListener(
                OtpKeyEvent(
                    etOtp3,
                    etOtp2
                )
            )
            etOtp4.setOnKeyListener(
                OtpKeyEvent(
                    etOtp4,
                    etOtp3
                )
            )
            etOtp5.setOnKeyListener(
                OtpKeyEvent(
                    etOtp5,
                    etOtp4
                )
            )
            etOtp6.setOnKeyListener(
                OtpKeyEvent(
                    etOtp6,
                    etOtp5
                )
            )
        }
        binding.btnSubmit.setOnClickListener {
            if (!validate()) return@setOnClickListener
            val otp =
                vm.otp1.value + vm.otp2.value + vm.otp3.value + vm.otp4.value + vm.otp5.value + vm.otp6.value
            vm.verifyOtp(otp)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) showKeyboard(binding.etOtp1)
        }, 300)

        arguments?.let {
            vm.state.value = it.getString("state")
            vm.country.value = it.getString("country")
            vm.phone.value = it.getString("phone")
            vm.transactionId.value = it.getString("transactionId")
            val duration = it.getString("duration")
            duration?.let { d -> startCountDownTimer(d.toLong()) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountDownTimer?.cancel()
    }

    private fun validate(): Boolean {
        var result = true
        if (vm.otp1.value == null || vm.otp1.value.isNullOrEmpty()
            || vm.otp2.value == null || vm.otp2.value.isNullOrEmpty()
            || vm.otp3.value == null || vm.otp3.value.isNullOrEmpty()
            || vm.otp4.value == null || vm.otp4.value.isNullOrEmpty()
            || vm.otp5.value == null || vm.otp5.value.isNullOrEmpty()
            || vm.otp6.value == null || vm.otp6.value.isNullOrEmpty()
        ) result = false
        val bg = if (result) cR.drawable.bg_white_round8_grey else cR.drawable.bg_white_round8_red
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
            sharedPreferences.edit()
                .putString(AppConstant.ACCESS_TOKEN, it.session?.token)
                .putString(AppConstant.REFRESH_TOKEN, it.session?.refreshToken)
                .apply()
            setFragmentResult(AuthConstant.SIGN_IN_REQ, bundleOf(AuthConstant.SIGN_IN_REQ to true))
            findNavController().navigateUp()
        }
    }

    private fun onOTPVerifyRegister(ticket: Ticket?) {
        ticket?.let {
            setFragmentResult(
                AuthConstant.VERIFY_REQ, bundleOf(
                    AuthConstant.COUNTRY to vm.country.value.toString(),
                    AuthConstant.PHONE to vm.phone.value.toString(),
                    AuthConstant.TRANSACTION_ID to it.transactionId,
                )
            )
        }
    }

    private class OtpKeyEvent(
        private val currentView: EditText,
        private val previousView: EditText?
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
            currentView.setBackgroundResource(cR.drawable.bg_white_round8_grey)
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
                vm.time.value = "$minutesLeft:$secondsLeft"
            }

            override fun onFinish() {
                vm.time.value = null
                vm.otpResend.value = getString(R.string.otp_resend)
                binding.tvOtpResend.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        cR.color.link
                    )
                )
                binding.tvOtpResend.setOnClickListener {
                    vm.resendOtp()
                }
            }
        }.start()
    }

    private fun onResendOtp(ticket: Ticket?) {
        ticket?.let {
            vm.transactionId.value = it.transactionId
            vm.otpResend.value = getString(R.string.otp_please_wait)
            binding.tvOtpResend.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    cR.color.grey80
                )
            )
            binding.tvOtpResend.setOnClickListener(null)
            it.otp?.duration?.let { d -> startCountDownTimer(d) }
        }
    }

}