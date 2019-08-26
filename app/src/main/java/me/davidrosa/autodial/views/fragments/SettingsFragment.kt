package me.davidrosa.autodial.views.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import me.davidrosa.autodial.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}