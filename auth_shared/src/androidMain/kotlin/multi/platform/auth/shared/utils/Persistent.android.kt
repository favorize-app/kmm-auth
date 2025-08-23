package multi.platform.auth.shared.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Android-specific implementation of Persistent using SharedPreferences.
 */
actual class Persistent(private val context: Context) {
    
    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("auth_shared_prefs", Context.MODE_PRIVATE)
    }
    
    actual fun putString(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }
    
    actual fun getString(key: String, defaultValue: String?): String? {
        return prefs.getString(key, defaultValue)
    }
    
    actual fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }
    
    actual fun clear() {
        prefs.edit().clear().apply()
    }
}