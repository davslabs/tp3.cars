package ort.tp3.cars.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import ort.tp3.cars.R
import ort.tp3.cars.dataclasses.BrandsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scrollLinearLayout: LinearLayout = view.findViewById(R.id.scrollLinearLayout)

        // Lista de las marcas de los autos: nombre + logo
        val brands: List<BrandsModel> = listOf(

            BrandsModel("Maserati", "https://www.carlogos.org/car-brands/maserati-logo.html"),
            BrandsModel("Mercedes-Benz", "https://www.carlogos.org/car-brands/mercedes-benz-logo.html"),
            BrandsModel("Porsche", "https://www.carlogos.org/logo/Porsche-logo.html"),
            BrandsModel("BMW", "https://www.carlogos.org/logo/BMW-logo-2000-1920x1080.png"),
            BrandsModel("Renault", "https://www.carlogos.org/logo/Renault-logo-2007-1920x1080.png"),
            BrandsModel("Lamborghini", "https://www.carlogos.org/logo/Lamborghini-logo-2007-1920x1080.png"),
        )

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


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}