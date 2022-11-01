package tossaro.android.auth.example.app

import androidx.navigation.fragment.NavHostFragment
import tossaro.android.auth.example.R
import tossaro.android.core.app.BaseActivity
import tossaro.android.core.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>(
    R.layout.main_activity
) {
    override fun appVersion() = getString(R.string.app_version)
    override fun actionBar() = binding.toolbar
    override fun bottomNavBar() = binding.bottomNav
    override fun navHostFragment() = binding.contentFragment.getFragment() as NavHostFragment
    override fun mainNavGraph() = R.navigation.main_nav_graph
    override fun authNavGraph() = R.navigation.auth_nav_graph
    override fun topLevelDestinations(): Set<Int> {
        val list = HashSet<Int>()
        list.add(R.id.signInFragment)
        list.add(R.id.registerFragment)
        list.add(R.id.profileFragment)
        return list
    }
}