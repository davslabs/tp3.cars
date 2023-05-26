package ort.tp3.cars.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("HomeFragment", "onViewCreated")

        val scrollLinearLayout: LinearLayout = view.findViewById(R.id.scrollLinearLayout)

        // Lista de las marcas de los autos: nombre + logo
        val brands: List<BrandsModel> = listOf(
            BrandsModel("Maserati", "https://www.carlogos.org/car-logos/maserati-logo-2020.png"),
            BrandsModel("Mercedes-Benz", "https://www.carlogos.org/logo/Mercedes-Benz-logo-2011-1920x1080.png"),
            BrandsModel("Porsche", "https://www.carlogos.org/logo/Porsche-logo.html"),
            BrandsModel("BMW", "https://www.carlogos.org/logo/BMW-logo-2000-1920x1080.png"),
            BrandsModel("Renault", "https://www.carlogos.org/logo/Renault-logo-2007-1920x1080.png"),
            BrandsModel("Lamborghini", "https://www.carlogos.org/logo/Lamborghini-logo-2007-1920x1080.png"),
        )

        Log.d("HomeFragment", "Brands: $brands")

        for (brand in brands) {
            val imageView = ImageView(requireContext())
            val textView = TextView(requireContext())

            // Configurar la imagen
            Glide.with(requireContext())
                .load(brand.logoUrl)
                .into(imageView)

            // Configurar el texto
            textView.text = brand.name

            // Agregar la imagen y el texto al LinearLayout
            scrollLinearLayout.addView(imageView)
            scrollLinearLayout.addView(textView)
        }
    }
}