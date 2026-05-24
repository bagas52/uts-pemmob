package com.example.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RestaurantPrefManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "bagas_resto_prefs",
        Context.MODE_PRIVATE
    )

    companion object {
        const val KEY_NAME = "restaurant_name"
        const val KEY_ADDRESS = "restaurant_address"
        const val KEY_DESC = "restaurant_desc"
        const val KEY_HOURS = "restaurant_hours"
        const val KEY_THEME = "theme_mode" // "light", "dark", "system"
        
        // Key to save interactive food items rating or user reviews mapping
        const val KEY_RATINGS_PREFIX = "menu_rating_"
    }

    init {
        // Initialize default values if not present
        if (!sharedPreferences.contains(KEY_NAME)) {
            sharedPreferences.edit().apply {
                putString(KEY_NAME, "Bagas Resto")
                putString(KEY_ADDRESS, "Jl. Kuliner Nusantara No. 88, Kebayoran Baru, Jakarta Selatan")
                putString(
                    KEY_DESC,
                    "Menyajikan cita rasa nusantara legendaris dengan resep turun-temurun. Kami hanya menggunakan bahan-bahan segar organik, rempah segar berkualitas, dan dimasak penuh kasih sayang."
                )
                putString(KEY_HOURS, "09:00 - 22:00 WIB")
                putString(KEY_THEME, "system")
                apply()
            }
        }
    }

    fun getRestaurantName(): String = sharedPreferences.getString(KEY_NAME, "Bagas Resto") ?: "Bagas Resto"
    fun getRestaurantAddress(): String = sharedPreferences.getString(KEY_ADDRESS, "") ?: ""
    fun getRestaurantDesc(): String = sharedPreferences.getString(KEY_DESC, "") ?: ""
    fun getRestaurantHours(): String = sharedPreferences.getString(KEY_HOURS, "") ?: ""
    fun getThemeMode(): String = sharedPreferences.getString(KEY_THEME, "system") ?: "system"

    fun saveProfile(name: String, address: String, desc: String, hours: String) {
        sharedPreferences.edit().apply {
            putString(KEY_NAME, name)
            putString(KEY_ADDRESS, address)
            putString(KEY_DESC, desc)
            putString(KEY_HOURS, hours)
            apply()
        }
    }

    fun saveThemeMode(mode: String) {
        sharedPreferences.edit().putString(KEY_THEME, mode).apply()
    }

    fun saveMenuRating(menuId: String, rating: Int) {
        sharedPreferences.edit().putInt(KEY_RATINGS_PREFIX + menuId, rating).apply()
    }

    fun getMenuRating(menuId: String): Int {
        return sharedPreferences.getInt(KEY_RATINGS_PREFIX + menuId, 4) // Default is 4 stars
    }
}
