package ort.tp3.cars.ui.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ort.tp3.cars.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}



