package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.data.RestaurantPrefManager
import com.example.model.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel(application: Application) : AndroidViewModel(application) {
    
    private val prefManager = RestaurantPrefManager(application)

    // Reactive state flows
    private val _restaurantName = MutableStateFlow(prefManager.getRestaurantName())
    val restaurantName: StateFlow<String> = _restaurantName.asStateFlow()

    private val _restaurantAddress = MutableStateFlow(prefManager.getRestaurantAddress())
    val restaurantAddress: StateFlow<String> = _restaurantAddress.asStateFlow()

    private val _restaurantDesc = MutableStateFlow(prefManager.getRestaurantDesc())
    val restaurantDesc: StateFlow<String> = _restaurantDesc.asStateFlow()

    private val _restaurantHours = MutableStateFlow(prefManager.getRestaurantHours())
    val restaurantHours: StateFlow<String> = _restaurantHours.asStateFlow()

    private val _themeMode = MutableStateFlow(prefManager.getThemeMode())
    val themeMode: StateFlow<String> = _themeMode.asStateFlow()

    // Ratings state
    private val _menuRatings = MutableStateFlow<Map<String, Int>>(emptyMap())
    val menuRatings: StateFlow<Map<String, Int>> = _menuRatings.asStateFlow()

    init {
        // Load initial ratings
        refreshRatings()
    }

    private fun refreshRatings() {
        val ratingsMap = mutableMapOf<String, Int>()
        MenuItem.dummyList.forEach { item ->
            ratingsMap[item.id] = prefManager.getMenuRating(item.id)
        }
        _menuRatings.value = ratingsMap
    }

    fun saveProfile(name: String, address: String, desc: String, hours: String) {
        prefManager.saveProfile(name, address, desc, hours)
        _restaurantName.value = name
        _restaurantAddress.value = address
        _restaurantDesc.value = desc
        _restaurantHours.value = hours
    }

    fun saveThemeMode(mode: String) {
        prefManager.saveThemeMode(mode)
        _themeMode.value = mode
    }

    fun saveMenuRating(menuId: String, rating: Int) {
        prefManager.saveMenuRating(menuId, rating)
        val current = _menuRatings.value.toMutableMap()
        current[menuId] = rating
        _menuRatings.value = current
    }

    fun getMenuRating(menuId: String): Int {
        return _menuRatings.value[menuId] ?: prefManager.getMenuRating(menuId)
    }

    fun refreshProfile() {
        _restaurantName.value = prefManager.getRestaurantName()
        _restaurantAddress.value = prefManager.getRestaurantAddress()
        _restaurantDesc.value = prefManager.getRestaurantDesc()
        _restaurantHours.value = prefManager.getRestaurantHours()
    }
}
