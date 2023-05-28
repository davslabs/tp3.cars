package ort.tp3.cars.helpers

import ort.tp3.cars.R

object ImageHelper {
    fun getLogoResourceId(brand: String): Int {
        return when (brand) {
            "bmw" -> R.drawable.logo_bmw
            "volkswagen" -> R.drawable.logo_vw
            "honda" -> R.drawable.logo_honda
            else -> R.drawable.logo_toyota
        }
    }
}
