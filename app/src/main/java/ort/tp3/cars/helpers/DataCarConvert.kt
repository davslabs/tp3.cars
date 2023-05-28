package ort.tp3.cars.helpers

import java.util.Locale

class DataCarConvert {
    fun convertTransmission(transmission: String): String {
        return when (transmission.lowercase(Locale.ROOT)) {
            "m" -> "Manual"
            "a" -> "Automátic"
            else -> transmission
        }
    }

    fun convertDrive(drive: String): String {
        return when (drive.lowercase(Locale.ROOT)) {
            "fwd" -> "Front-Wheel drive"
            "rwd" -> "Rear-Wheel drive"
            "awd" -> "All-Wheel drive"
            "4wd" -> "Four-Wheel drive"
            else -> drive
        }
    }

    fun convertFuelType(fuelType: String): String {
        return when (fuelType.lowercase(Locale.ROOT)) {
            "gas" -> "Gas"
            "diesel" -> "Diesel"
            "electricity" -> "Electrico"
            else -> fuelType
        }
    }
}
