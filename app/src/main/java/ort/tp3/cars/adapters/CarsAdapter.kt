package ort.tp3.cars.adapters

import CarModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ort.tp3.cars.R

class CarsAdapter : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    private var carsList: List<CarModel> = emptyList()

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

    inner class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carNameTextView: TextView = itemView.findViewById(R.id.carNameTextView)
        private val carModelTextView: TextView = itemView.findViewById(R.id.carModelTextView)
        private val carYearTextView: TextView = itemView.findViewById(R.id.carYearTextView)
        fun bind(car: CarModel) {
            carNameTextView.text = car.make
            carModelTextView.text = car.model
            carYearTextView.text = car.year.toString()
        }
    }
}

