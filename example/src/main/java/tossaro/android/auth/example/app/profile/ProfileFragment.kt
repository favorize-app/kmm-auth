package tossaro.android.auth.example.app.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import tossaro.android.auth.example.R
import tossaro.android.auth.example.app.MainActivity
import tossaro.android.auth.example.databinding.ProfileFragmentBinding
import tossaro.android.core.app.BaseFragment
import tossaro.android.core.external.constant.AppConstant

class ProfileFragment : BaseFragment<ProfileFragmentBinding>(R.layout.profile_fragment) {
    override fun isActionBarShown() = false
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignOut.setOnClickListener {
            sharedPreferences.edit().remove(AppConstant.ACCESS_TOKEN)
                .remove(AppConstant.REFRESH_TOKEN).apply()
            requireActivity().finish()
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }
}