package ort.tp3.cars.ui.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scrollLinearLayout: LinearLayout = view.findViewById(R.id.scrollLinearLayout)

        // Lista de las marcas de los autos: nombre + logo
        val brands: List<BrandsModel> = listOf(
            BrandsModel("Maserati", "https://www.carlogos.org/car-logos/maserati-logo-2006-900x1200.png"),
            BrandsModel("Mercedes", "https://www.carlogos.org/logo/Mercedes-Benz-logo-2011-1920x1080.png"),
            BrandsModel("Audi", "https://www.carlogos.org/car-logos/audi-logo-2016.png"),
            BrandsModel("Renault", "https://www.carlogos.org/logo/Renault-logo-2015-2048x2048.png"),
            BrandsModel("Porsche", "https://www.carlogos.org/car-logos/porsche-logo-950x1100.png"),
            BrandsModel("Jeep", "https://www.carlogos.org/car-logos/jeep-logo-1993.png"),
        )

        for (brand in brands) {
            val container = CardView(requireContext())
            container.radius = 10f // Establece el radio de las esquinas redondeadas
            container.cardElevation = 8f // Establece la elevación para aplicar sombreado

            val containerParams = LinearLayout.LayoutParams(
                380, // Establece el ancho del contenedor
                280 // Establece el alto del contenedor
            )
            containerParams.marginEnd = 18 // Establece el margen entre los contenedores

            container.layoutParams = containerParams // Establece los parámetros del contenedor

            // Crear LinearLayout vertical para imagen y texto
            val linearLayout = LinearLayout(requireContext())
            linearLayout.orientation = LinearLayout.VERTICAL // Establece la orientación vertical
            linearLayout.gravity = Gravity.CENTER // Centra el contenido del LinearLayout

            val imageView = ImageView(requireContext())
            val textView = TextView(requireContext())

            // Configurar el texto
            textView.text = brand.name
            textView.textSize = 13f // Tamaño de texto en sp
            textView.setTextColor(Color.BLACK) // Color del texto en negro

            // Agregar el texto al LinearLayout
            val textViewParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textViewParams.gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM // Alineación en la parte inferior y centrado horizontal
            textView.layoutParams = textViewParams

            // Configurar la imagen
            val imageParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
            imageParams.addRule(RelativeLayout.CENTER_IN_PARENT) // Centra la imagen dentro del contenedor

            Glide.with(requireContext())
                .load(brand.logoUrl)
                .fitCenter() // Ajusta la imagen al centro manteniendo la relación de aspecto
                .override(180, 180) // Establece el tamaño deseado para la imagen (ajusta según tus necesidades)
                .into(imageView)

            // Agregar la imagen y el texto al LinearLayout vertical
            linearLayout.addView(imageView)
            linearLayout.addView(textView)

            // Agregar el LinearLayout al contenedor
            container.addView(linearLayout)

            scrollLinearLayout.addView(container)
        }
    }
}