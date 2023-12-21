package ru.lunk_corp.space_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import ru.lunk_corp.space_app.Models.astro_responce

class Astronauts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronauts)

        val exit: ImageView = findViewById(R.id.astro_exit)
        val people: TextView = findViewById(R.id.description_a)
        var desc = "Космонавты, находящиеся на МКС в настоящее время: \n\n"
        val astro = intent.getParcelableExtra<astro_responce>("astro")?.people
        for (i in astro!!){
            desc+=(i.name + " in " + i.craft + "\n")
        }
        people.text = desc

        exit.setOnClickListener {
            finish()
        }
    }
}