package multi.platform.auth.shared.utils

/**
 * Persistent storage utility for the auth shared module.
 * This provides a simple key-value storage interface.
 */
expect class Persistent {
    /**
     * Stores a string value with the given key.
     */
    fun putString(key: String, value: String)
    
    /**
     * Retrieves a string value with the given key.
     */
    fun getString(key: String, defaultValue: String? = null): String?
    
    /**
     * Removes a value with the given key.
     */
    fun remove(key: String)
    
    /**
     * Clears all stored values.
     */
    fun clear()
}