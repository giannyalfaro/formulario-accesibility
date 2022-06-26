package com.example.accesibilidadejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivityExito : AppCompatActivity() {
    private var txtViewSuccess: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_exito)
        txtViewSuccess = findViewById<View>(R.id.tvSuccessDescription) as TextView
        txtViewSuccess!!.requestFocus()
    }
}