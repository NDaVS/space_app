package ru.lunk_corp.space_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ru.lunk_corp.space_app.ViewModels.marsPhotoViewModel

class Mars_Photo : AppCompatActivity() {
    private lateinit var viewModel: marsPhotoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_photo)

        val marsPhoto: ImageView = findViewById(R.id.photo_2023_)
        val description: TextView = findViewById(R.id.photo_description)
        val exit:ImageView = findViewById(R.id.photo_exit_button)

        exit.setOnClickListener {
            finish()
        }

    }
}