package ru.lunk_corp.space_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.lunk_corp.space_app.Models.APOD_Data

class APOD : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)

        var desc: TextView = findViewById(R.id.description)
        val apod_data: APOD_Data? = intent.getParcelableExtra("apod")
        if (apod_data != null) {
            desc.text = apod_data.explanation
        }
        
    }
}