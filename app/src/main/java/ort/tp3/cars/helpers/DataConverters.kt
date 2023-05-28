package ort.tp3.cars.helpers

import java.util.Locale

sealed class Transmission {
    object Manual : Transmission()
    object Automatic : Transmission()
    data class Other(val value: String) : Transmission()

    companion object {
        fun fromString(value: String): Transmission {
            return when (value.lowercase(Locale.ROOT)) {
                "m" -> Manual
                "a" -> Automatic
                else -> Other(value)
            }
        }
    }
}

sealed class Drive {
    object FrontWheelDrive : Drive()
    object RearWheelDrive : Drive()
    object AllWheelDrive : Drive()
    object FourWheelDrive : Drive()
    data class Other(val value: String) : Drive()

    companion object {
        fun fromString(value: String): Drive {
            return when (value.lowercase(Locale.ROOT)) {
                "fwd" -> FrontWheelDrive
                "rwd" -> RearWheelDrive
                "awd" -> AllWheelDrive
                "4wd" -> FourWheelDrive
                else -> Other(value)
            }
        }
    }
}

sealed class FuelType {
    object Gas : FuelType()
    object Diesel : FuelType()
    object Electricity : FuelType()
    data class Other(val value: String) : FuelType()

    companion object {
        fun fromString(value: String): FuelType {
            return when (value.lowercase(Locale.ROOT)) {
                "gas" -> Gas
                "diesel" -> Diesel
                "electricity" -> Electricity
                else -> Other(value)
            }
        }
    }
}