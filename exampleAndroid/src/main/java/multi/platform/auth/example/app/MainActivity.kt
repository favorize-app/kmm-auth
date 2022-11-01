package multi.platform.auth.example.app

import multi.platform.auth.example.R
import multi.platform.core.shared.app.common.BaseActivity
import multi.platform.auth.R as aR

class MainActivity : BaseActivity() {
    override fun appVersion() = getString(R.string.app_version)
    override fun navGraph() = R.navigation.main_nav_graph
    override fun topLevelDestinations(): Set<Int> {
        val list = HashSet<Int>()
        list.add(aR.id.signInFragment)
        list.add(aR.id.registerFragment)
        list.add(R.id.profileFragment)
        return list
    }
}