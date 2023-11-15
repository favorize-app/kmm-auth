package multi.platform.auth.example.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.collection.forEach
import androidx.navigation.fragment.NavHostFragment
import multi.platform.auth.example.BuildConfig
import multi.platform.auth.example.databinding.MainActivityBinding
import multi.platform.core.shared.app.common.CoreActivity
import timber.log.Timber
import multi.platform.core.shared.R as cR

class MainActivity : CoreActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var binding: MainActivityBinding
    private lateinit var navHostFragment: NavHostFragment

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navHostFragment.navController.handleDeepLink(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navHostFragment = binding.contentFragment.getFragment() as NavHostFragment

        val navController = navHostFragment.navController
        navController.graph.nodes.forEach { key, value ->
            Timber.d("nodes $key: ${value.id} => ${value.route}")
        }
        navController.addOnDestinationChangedListener { controller, _, _ ->
            @Suppress("RestrictedApi")
            if (BuildConfig.DEBUG) {
                val breadcrumb = controller.currentBackStack.value
                    .map { it.destination }
                    .joinToString(" > ") {
                        it.displayName.split('/')[1]
                    }
                Timber.d("breadcrumb: $breadcrumb")
            }
        }
    }

    @Suppress("DEPRECATED", "kotlin:S1874")
    override fun onBackPressed() {
        if (navHostFragment.childFragmentManager.backStackEntryCount == 0) {
            if (doubleBackToExitPressedOnce) finish()

            doubleBackToExitPressedOnce = true
            Toast.makeText(
                this,
                getString(cR.string.tap_to_minimize),
                Toast.LENGTH_SHORT,
            ).show()

            Handler(Looper.getMainLooper()).postDelayed({
                doubleBackToExitPressedOnce = false
            }, 2000)
        } else super.onBackPressed()
    }
}
