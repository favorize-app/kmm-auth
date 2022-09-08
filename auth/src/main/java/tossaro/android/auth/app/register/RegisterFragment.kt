package tossaro.android.auth.app.register

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.R
import tossaro.android.auth.databinding.RegisterFragmentBinding
import tossaro.android.core.app.BaseActivity
import tossaro.android.core.app.BaseFragment

class RegisterFragment : BaseFragment<RegisterFragmentBinding>(
    R.layout.register_fragment
) {
    private var doubleBackToExitPressedOnce = false
    private val vm: RegisterViewModel by viewModel()

    override fun actionBarTitle() = getString(R.string.register_title)
    override fun isBottomNavBarShown() = false

    override fun onBackPressed(): Boolean {
        if (doubleBackToExitPressedOnce) {
            activity?.finish()
            return true
        }

        doubleBackToExitPressedOnce = true
        Toast.makeText(
            context,
            getString(R.string.tap_to_minimize),
            Toast.LENGTH_SHORT
        ).show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm.also {
            it.onSignedIn.observe(viewLifecycleOwner, ::onSignedIn)
        }
        arguments?.let {
            vm.country.value = it.getString("country")
            vm.phone.value = it.getString("phone")
        }
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
}