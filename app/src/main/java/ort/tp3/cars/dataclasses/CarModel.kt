import com.google.gson.annotations.SerializedName

data class CarModel(
    @SerializedName("city_mpg") val cityMpg: Int,
    @SerializedName("class") val carClass: String,
    @SerializedName("combination_mpg") val combinationMpg: Int,
    val cylinders: Int,
    val displacement: Double,
    val drive: String,
    @SerializedName("fuel_type") val fuelType: String,
    @SerializedName("highway_mpg") val highwayMpg: Int,
    val make: String,
    val model: String,
    val transmission: String,
    val year: Int
)
