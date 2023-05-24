package ort.tp3.cars.ui.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R
import ort.tp3.cars.adapters.CarsAdapter
import ort.tp3.cars.databinding.ActivityMainBinding
import ort.tp3.cars.ui.viewmodels.CarsViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var carsAdapter: CarsAdapter
    private val carsViewModel: CarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carsAdapter = CarsAdapter()
        recyclerView = findViewById(R.id.carsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = carsAdapter

        carsViewModel.onCreate()

        carsViewModel.carsModel.observe(this, Observer {
            carsAdapter.setCarsList(it)
        })

        carsViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        carsViewModel.onCreate()
    }
}