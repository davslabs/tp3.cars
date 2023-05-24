package ort.tp3.cars.ui.viewmodels

import CarModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ort.tp3.cars.services.CarsService
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carsService: CarsService
) : ViewModel() {
    val carsModel = MutableLiveData<List<CarModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            // TODO: Esto es un hardcodeo, debería ser un parámetro de entrada
            val cars = carsService.getCarsByModel("camry")

            cars.let {
                carsModel.value = it
            }

            isLoading.postValue(false)
        }
    }
}
