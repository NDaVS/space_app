package ru.lunk_corp.space_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ru.lunk_corp.space_app.Models.APOD_Data
import ru.lunk_corp.space_app.ViewModels.APODViewModel

class APOD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)

        val desc: TextView = findViewById(R.id.description)
        val image: ImageView = findViewById(R.id.photo_2023_)
        val exit: ImageView = findViewById(R.id.apod_exit)

        val viewModel = ViewModelProvider(this)[APODViewModel::class.java]

        val apod_data: APOD_Data? = intent.getParcelableExtra("apod")
        if (apod_data != null) {
            desc.text = apod_data.explanation
            viewModel.getAPODImage(image, apod_data.url)
        }
        exit.setOnClickListener {
            finish()
        }
        
    }
}