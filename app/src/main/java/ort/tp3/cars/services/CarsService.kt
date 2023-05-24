package ort.tp3.cars.services

import CarModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsService @Inject constructor(
    private val api: CarsApi
) {
    suspend fun getCarsByModel(model: String): List<CarModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getCarsByModel(model)
            response.body() ?: emptyList()
        }
    }
}
