package multi.platform.auth.example.app.profile

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import multi.platform.auth.example.R
import multi.platform.auth.example.databinding.ProfileFragmentBinding
import multi.platform.auth.shared.external.constants.AuthKey
import multi.platform.core.shared.app.common.CoreFragment
import multi.platform.core.shared.external.constants.CommonKey
import multi.platform.core.shared.external.extensions.goTo
import org.koin.core.component.inject
import timber.log.Timber

class ProfileFragment : CoreFragment() {
    private val sharedPreferences: SharedPreferences by inject()
    private val profileViewModel: ProfileViewModel by inject()
    private lateinit var binding: ProfileFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(AuthKey.SIGN_OUT_KEY) { _, b ->
            if (b.getBoolean(AuthKey.SIGN_OUT_KEY)) {
                sharedPreferences.edit().remove(CommonKey.ACCESS_TOKEN_KEY)
                    .remove(CommonKey.REFRESH_TOKEN_KEY).apply()
                profileViewModel.clear()
                onResume()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            profileVM = profileViewModel
            btnSignIn.setOnClickListener {
                goTo(getString(R.string.route_auth_sign_in_full))
            }
            btnSignOut.setOnClickListener {
                goTo(getString(R.string.route_auth_sign_out_full))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val savedStateHandle = findNavController().currentBackStackEntry!!.savedStateHandle
        Timber.d("savedStateHandle = " + savedStateHandle.getLiveData<Boolean>(AuthKey.SIGN_IN_KEY).value.toString())
        val accessToken = sharedPreferences.getString(CommonKey.ACCESS_TOKEN_KEY, null)
        profileViewModel.accessToken = accessToken
        accessToken?.let {
            val appPackageName = requireContext().packageName
            val pInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requireContext().packageManager?.getPackageInfo(
                    appPackageName.toString(),
                    PackageManager.PackageInfoFlags.of(0L),
                )
            } else {
                @Suppress("DEPRECATION")
                requireContext().packageManager?.getPackageInfo(appPackageName.toString(), 0)
            }
            val versionName = pInfo?.versionName
            val playerId = OneSignal.User.pushSubscription.id

            MainScope().launch {
                val androidId = getDeviceId().await()
                profileViewModel.getProfile(versionName, androidId, playerId)
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getDeviceId() = GlobalScope.async {
        AdvertisingIdClient.getAdvertisingIdInfo(requireContext()).id
    }
}
