package ort.tp3.cars.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import dagger.hilt.android.AndroidEntryPoint
import ort.tp3.cars.R

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.loginButton)
        val username: TextView = findViewById(R.id.emailLogin)

        loginButton.setOnClickListener {
            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", username.text.toString())
            startActivity(intent)
        }
    }
}
