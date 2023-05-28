package ort.tp3.cars.adapters

import ort.tp3.cars.dataclasses.CarModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.helpers.DataCarConvert
import ort.tp3.cars.helpers.ImageHelper.getLogoResourceId

class CarsAdapter : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    private var carsList: List<CarModel> = emptyList()

    private val dataCarConvert = DataCarConvert()


    fun setCarsList(carsList: List<CarModel>) {
        this.carsList = carsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val car = carsList[position]
        holder.bind(car)
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    fun setBrands(brands: List<BrandsModel>) {
        TODO("Not yet implemented")
    }

    inner class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carLogoImageView: ImageView = itemView.findViewById(R.id.carLogoImageView)
        private val carModelTextView: TextView = itemView.findViewById(R.id.carModelTextView)
        private val carDriveTextView: TextView = itemView.findViewById(R.id.carDriveTextView)
        private val carTransmission: TextView = itemView.findViewById(R.id.carTransmission)
        private val carYearTextView: TextView = itemView.findViewById(R.id.carYearTextView)
        private val carFuelTypeTextView: TextView = itemView.findViewById(R.id.carFuelTypeTextView)

        fun bind(car: CarModel) {


            val fuelText = dataCarConvert.convertFuelType(car.fuelType)
            val transmissionText = dataCarConvert.convertTransmission(car.transmission);
            val driveText = dataCarConvert.convertDrive(car.drive)

            carLogoImageView.setImageResource(getLogoResourceId(car.make))
            carYearTextView.text = car.year.toString()
            carModelTextView.text = car.model
            carDriveTextView.text = driveText
            carTransmission.text = transmissionText
            carFuelTypeTextView.text = fuelText

        }

    }
}

