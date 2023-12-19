package ru.lunk_corp.space_app

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ru.lunk_corp.space_app.ViewModels.MainViewModel

class MainActivity : AppCompatActivity() {
//    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apod_button:TextView = findViewById(R.id.apod)
        val mars_photo:TextView = findViewById(R.id.mars_photo)
        val astronauts:TextView = findViewById(R.id.astronauts)

    var viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    viewModel.apod_Data.observe(this){
        intent = Intent(this, APOD::class.java)
        intent.putExtra("apod", it)
        startActivity(intent)
    }
    apod_button.setOnClickListener {
            viewModel.getAPOD()

        }

        mars_photo.setOnClickListener {
            startActivity(Intent(this, Mars_Photo::class.java))
        }

        astronauts.setOnClickListener {
            startActivity(Intent(this, Astronauts::class.java))
        }

    }
}