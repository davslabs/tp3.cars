package ort.tp3.cars.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ort.tp3.cars.R
import ort.tp3.cars.adapters.BrandsAdapter
import ort.tp3.cars.data.CarsRepository
import ort.tp3.cars.dataclasses.BrandsModel
import ort.tp3.cars.ui.viewmodels.CarsViewModel
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val carsViewModel: CarsViewModel by activityViewModels()
    @Inject
    lateinit var carsRepository: CarsRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val adapter = BrandsAdapter(requireContext(), mutableListOf())
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : BrandsAdapter.OnItemClickListener {
            override fun onItemClick(brand: BrandsModel) {
                handleBrandClick(brand)
            }
        })

        lifecycleScope.launch {
            val brands = carsRepository.getAvailableBrands()
            adapter.setBrands(brands)
        }
    }

    fun handleBrandClick(brand: BrandsModel) {
        carsViewModel.setFilter(mapOf(
            "make" to brand.name
        ))

        val navController = findNavController()
        navController.navigate(R.id.action_home_to_cars)
    }
}