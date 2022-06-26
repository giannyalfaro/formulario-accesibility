package com.example.accesibilidadejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickSinAccesibilidad(view: View) {
        val intent = Intent(this, MainActivitySinAccesibilidad::class.java)
        startActivity(intent)
    }
    fun clickPatron1(view: View) {
        val intent = Intent(this, MainActivityPatron1::class.java)
        startActivity(intent)
    }
    fun clickPatron2(view: View) {
        val intent = Intent(this, MainActivityPatron2::class.java)
        startActivity(intent)
    }
}