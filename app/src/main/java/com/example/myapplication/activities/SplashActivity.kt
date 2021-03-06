package com.example.myapplication.activities

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.myapplication.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var _binding: ActivitySplashBinding
    private val binding
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        loadDefaultTheme()
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }

    private fun loadDefaultTheme() {
        val sharedPreferences = getSharedPreferences(SETTINGS_BUNDLE, Activity.MODE_PRIVATE)
        val enableNightTheme = sharedPreferences.getBoolean(SETTINGS_THEME, SHARED_THEME_ON)
        setDefaultTheme(enableNightTheme)
    }

    private fun setDefaultTheme(enableNightTheme: Boolean) {
        when (enableNightTheme) {
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    companion object {
        private const val SHARED_THEME_ON = false
        private const val SETTINGS_BUNDLE = "Settings"
        private const val SETTINGS_THEME = "My_theme"
    }
}