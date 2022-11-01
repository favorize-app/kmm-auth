package multi.platform.auth.example.app.profile

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import multi.platform.auth.example.R
import multi.platform.auth.R as aR
import multi.platform.auth.example.databinding.ProfileFragmentBinding
import multi.platform.core.shared.app.common.BaseFragment
import multi.platform.core.shared.external.constant.AppConstant
import multi.platform.core.shared.external.extension.goTo

class ProfileFragment : BaseFragment<ProfileFragmentBinding>(R.layout.profile_fragment) {
    override fun actionBarTitle() = getString(R.string.title)
    override fun showBottomNavBar() = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIn.setOnClickListener {
            goTo(getString(aR.string.route_signin))
        }
        binding.btnSignOut.setOnClickListener {
            sharedPreferences.edit().remove(AppConstant.ACCESS_TOKEN)
                .remove(AppConstant.REFRESH_TOKEN).apply()
            onResume()
        }
    }

    override fun onResume() {
        super.onResume()
        val accessToken = sharedPreferences.getString(AppConstant.ACCESS_TOKEN, null)
        binding.btnSignOut.isVisible = accessToken != null
        binding.btnSignIn.isVisible = accessToken == null
    }
}