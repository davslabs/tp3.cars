package ort.tp3.cars.data.local

import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.dataclasses.CarFilterModel
import javax.inject.Inject

class CarsLocalService @Inject constructor() {
    suspend fun getAvailableBrands(): List<BrandsModel> {
        return listOf(
            BrandsModel(
                "Maserati",
                "https://www.carlogos.org/car-logos/maserati-logo-2006-900x1200.png"
            ),
            BrandsModel(
                "Mercedes",
                "https://www.carlogos.org/logo/Mercedes-Benz-logo-2011-1920x1080.png"
            ),
            BrandsModel("Audi", "https://www.carlogos.org/car-logos/audi-logo-2016.png"),
            BrandsModel("Renault", "https://www.carlogos.org/logo/Renault-logo-2015-2048x2048.png"),
            BrandsModel("Porsche", "https://www.carlogos.org/car-logos/porsche-logo-950x1100.png"),
            BrandsModel("Jeep", "https://www.carlogos.org/car-logos/jeep-logo-1993.png"),
        )
    }

    suspend fun getAvailableFilters(): List<CarFilterModel> {
        return listOf(
            CarFilterModel("NAFTA", "gas", "#FFCC00", R.drawable.nafta),
            CarFilterModel("DIESEL", "diesel", "#3330E5", R.drawable.diesel),
            CarFilterModel("ELÉCTRICO", "electricity", "#04D9FF", R.drawable.electrico),
        )
    }
}