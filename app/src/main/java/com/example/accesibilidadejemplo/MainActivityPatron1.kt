package com.example.accesibilidadejemplo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.system.exitProcess

class MainActivityPatron1 : AppCompatActivity() {

    private var buttonSend: AppCompatButton? = null
        private var edtViewNameLayout:TextInputLayout? = null
    private var edtViewApellidoLayout:TextInputLayout? = null
    private var edtViewMascotaLayout:TextInputLayout? = null

    private var editTextName:TextInputEditText? = null
    private var editTextLastName:TextInputEditText? = null
    private var editTextPetName:TextInputEditText? = null

    private var txtViewGeneral:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_patron_1)
        buttonSend = findViewById<View>(R.id.btnEnviar) as AppCompatButton
        edtViewNameLayout = findViewById<View>(R.id.edtViewName) as TextInputLayout
        edtViewApellidoLayout = findViewById<View>(R.id.edtViewApellido) as TextInputLayout
        edtViewMascotaLayout = findViewById<View>(R.id.edtViewMascota) as TextInputLayout

        editTextName = findViewById<View>(R.id.edit_text_name) as TextInputEditText
        editTextLastName = findViewById<View>(R.id.edit_text_apellido) as TextInputEditText
        editTextPetName = findViewById<View>(R.id.edit_text_mascota) as TextInputEditText

        editTextName!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                if(s.isNotEmpty()){
                    edtViewNameLayout?.error = ""
                }
            }
        })

        editTextLastName!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                if(s.isNotEmpty()){
                    edtViewApellidoLayout?.error = ""
                }
            }
        })

        editTextPetName!!.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                if(s.isNotEmpty()){
                    edtViewMascotaLayout?.error = ""
                }
            }
        })

        txtViewGeneral = findViewById<View>(R.id.txtViewGeneral) as TextView
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendData(view: View) {

        if(editTextName?.text!!.isEmpty()){
            edtViewNameLayout?.error = "Error: Ingresa tu nombre"
        }

        if(editTextLastName?.text!!.isEmpty()){
            edtViewApellidoLayout?.error = "Error: Ingresa tu apellido"
        }

        if(editTextPetName?.text!!.isEmpty()){
            edtViewMascotaLayout?.error = "Error: Ingresa el nombre de tu mascota"
        }
        if(editTextName?.text!!.isNotEmpty() && editTextLastName?.text!!.isNotEmpty() &&
            editTextPetName?.text!!.isNotEmpty()){
            editTextName?.setText(R.string.app_white_black)
            editTextLastName?.setText(R.string.app_white_black)
            editTextPetName?.setText(R.string.app_white_black)

            val intent = Intent(this, MainActivityExito::class.java)
            startActivity(intent)
        }
    }
}