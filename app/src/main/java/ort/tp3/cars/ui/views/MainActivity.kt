package ort.tp3.cars.ui.views

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R
import ort.tp3.cars.adapters.CarsAdapter
import ort.tp3.cars.databinding.ActivityMainBinding
import ort.tp3.cars.ui.viewmodels.CarsViewModel
import ort.tp3.cars.ui.viewmodels.SharedViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        val email = intent.getStringExtra("username")

        if (email != null) {
            sharedViewModel.setUsername(email)
        } else {
            sharedViewModel.setUsername("Usuario")
        }

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        bottomNavView = findViewById(R.id.menu)

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
    }
}