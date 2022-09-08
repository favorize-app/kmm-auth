package tossaro.android.auth.app.otp

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
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.R
import tossaro.android.auth.databinding.OtpDialogFragmentBinding
import tossaro.android.core.BuildConfig
import tossaro.android.core.app.BaseActivity
import tossaro.android.core.app.BaseDialogFragment
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.external.ext.showKeyboard


class OtpDialogFragment : BaseDialogFragment<OtpDialogFragmentBinding>(
    R.layout.otp_dialog_fragment
) {

    private val viewModel: OtpDialogViewModel by viewModel()
    private var mCountDownTimer: CountDownTimer? = null

    override fun isCancelable() = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel.also {
            it.sharedPrefs.value = sharedPreferences
            it.loadingIndicator.observe(viewLifecycleOwner, ::showFullLoading)
            it.onSignedIn.observe(viewLifecycleOwner, ::onSignedIn)
            it.onResendOtp.observe(viewLifecycleOwner, ::onResendOtp)
            it.onOTPVerifyRegister.observe(viewLifecycleOwner, ::onOTPVerifyRegister)
            it.otpResend.value = getString(R.string.otp_please_wait)
        }
        binding.apply {
            etOtp1.addTextChangedListener(OtpTextWatcher(etOtp1, etOtp2))
            etOtp2.addTextChangedListener(OtpTextWatcher(etOtp2, etOtp3))
            etOtp3.addTextChangedListener(OtpTextWatcher(etOtp3, etOtp4))
            etOtp4.addTextChangedListener(OtpTextWatcher(etOtp4, etOtp5))
            etOtp5.addTextChangedListener(OtpTextWatcher(etOtp5, etOtp6))
            etOtp6.addTextChangedListener(OtpTextWatcher(etOtp6, null))

            etOtp1.setOnKeyListener(OtpKeyEvent(etOtp1, null))
            etOtp2.setOnKeyListener(OtpKeyEvent(etOtp2, etOtp1))
            etOtp3.setOnKeyListener(OtpKeyEvent(etOtp3, etOtp2))
            etOtp4.setOnKeyListener(OtpKeyEvent(etOtp4, etOtp3))
            etOtp5.setOnKeyListener(OtpKeyEvent(etOtp5, etOtp4))
            etOtp6.setOnKeyListener(OtpKeyEvent(etOtp6, etOtp5))
            btnSubmit.setOnClickListener {
                if (viewModel.otp1.value == null || viewModel.otp1.value.isNullOrEmpty()
                    || viewModel.otp2.value == null || viewModel.otp2.value.isNullOrEmpty()
                    || viewModel.otp3.value == null || viewModel.otp3.value.isNullOrEmpty()
                    || viewModel.otp4.value == null || viewModel.otp4.value.isNullOrEmpty()
                    || viewModel.otp5.value == null || viewModel.otp5.value.isNullOrEmpty()
                    || viewModel.otp6.value == null || viewModel.otp6.value.isNullOrEmpty()
                ) {
                    etOtp1.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    etOtp2.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    etOtp3.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    etOtp4.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    etOtp5.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    etOtp6.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.bg_white_round8_red)
                    return@setOnClickListener
                }
                val otp =
                    viewModel.otp1.value + viewModel.otp2.value + viewModel.otp3.value + viewModel.otp4.value + viewModel.otp5.value + viewModel.otp6.value
                viewModel.verifyOtp(otp.toLong())
            }
            Handler(Looper.getMainLooper()).postDelayed({
                showKeyboard(binding.etOtp1)
            }, 100)
        }

        arguments?.let {
            viewModel.type.value = it.getString("type")
            viewModel.country.value = it.getString("country")
            viewModel.phone.value = it.getString("phone")
            viewModel.ticketId.value = it.getString("ticketId")
            val duration = it.getString("duration")
            duration?.let { d -> startCountDownTimer(d.toLong()) }
            if (BuildConfig.DEBUG) Timber.d(
                "arguments: "
                        + viewModel.type.value.toString() + ","
                        + viewModel.country.value.toString() + ","
                        + viewModel.phone.value.toString() + ","
                        + viewModel.ticketId.value.toString() + ","
                        + duration.toString()
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCountDownTimer = null
    }

    private fun onSignedIn(path: String) {
        if (path == AuthRouters.HOME) {
            val mainNavGraph = (requireActivity() as BaseActivity<*>).mainNavGraph()
            mainNavGraph?.let {
                findNavController().graph.clear()
                findNavController().setGraph(it)
            }
        }
    }

    private fun onOTPVerifyRegister(ticket: Ticket?) {
        val args = bundleOf()
        args.putString("country", viewModel.country.value.toString())
        args.putString("phone", viewModel.phone.value.toString())
        findNavController().graph.clear()
        findNavController().setGraph(R.navigation.register_nav_graph, args)
    }

    private class OtpKeyEvent(
        private val currentView: EditText,
        private val previousView: EditText?
    ) : View.OnKeyListener {
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if (event?.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.etOtp1 && currentView.text.isEmpty()) {
                previousView?.text = null
                previousView?.requestFocus()
                return true
            }
            return false
        }
    }

    @Suppress("kotlin:S1186")
    private class OtpTextWatcher(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            val text = editable.toString()
            when (currentView.id) {
                R.id.etOtp1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etOtp2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etOtp3 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etOtp4 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.etOtp5 -> if (text.length == 1) nextView!!.requestFocus()
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
                viewModel.time.value = "$minutesLeft:$secondsLeft"
            }

            override fun onFinish() {
                viewModel.time.value = null
                viewModel.otpResend.value = getString(R.string.otp_try_again)
                binding.tvResend.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.headerText
                    )
                )
                binding.tvResend.setOnClickListener {
                    viewModel.resendOtp()
                }
            }
        }.start()
    }

    private fun onResendOtp(ticket: Ticket?) {
        ticket?.let {
            viewModel.ticketId.value = it.ticketId
            viewModel.otpResend.value = getString(R.string.otp_please_wait)
            binding.tvResend.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.bodyText2
                )
            )
            startCountDownTimer(it.duration)
        }
    }

}