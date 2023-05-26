package ort.tp3.cars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.adapters.CarsAdapter
import ort.tp3.cars.databinding.FragmentCarsBinding
import ort.tp3.cars.ui.viewmodels.CarsViewModel

@AndroidEntryPoint
class CarsFragment : Fragment() {
    private var _binding: FragmentCarsBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var carsAdapter: CarsAdapter
    private val carsViewModel: CarsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCarsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carsAdapter = CarsAdapter()
        recyclerView = binding.recCars
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = carsAdapter

        carsViewModel.onCreate()

        carsViewModel.carsModel.observe(viewLifecycleOwner) {
            carsAdapter.setCarsList(it)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
