package ru.lunk_corp.space_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Astronauts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronauts)

        val exit: ImageView = findViewById(R.id.astro_exit)

        exit.setOnClickListener {
            finish()
        }
    }
}