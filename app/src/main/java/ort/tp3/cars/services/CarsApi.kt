package ort.tp3.cars.services

import CarModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CarsApi {
    @GET("/v1/cars")
    suspend fun getCarsByModel(
        @Query("model") model: String
    ): Response<List<CarModel>>
}