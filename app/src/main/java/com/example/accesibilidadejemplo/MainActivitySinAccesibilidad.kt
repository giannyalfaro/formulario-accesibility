package com.example.accesibilidadejemplo

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

class MainActivitySinAccesibilidad : AppCompatActivity() {

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
        setContentView(R.layout.activity_main_sin_accesibilidad)
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
            edtViewNameLayout?.error = "Ingresa esta información"
        }else{
            edtViewNameLayout?.error = ""
        }

        if(editTextLastName?.text!!.isEmpty()){
            edtViewApellidoLayout?.error = "Ingresa esta información"
        }else{
            edtViewApellidoLayout?.error = ""
        }

        if(editTextPetName?.text!!.isEmpty()){
            edtViewMascotaLayout?.error = "Ingresa esta información"
        }else{
            edtViewMascotaLayout?.error = ""
        }

        if(editTextName?.text!!.isNotEmpty() && editTextLastName?.text!!.isNotEmpty() &&
            editTextPetName?.text!!.isNotEmpty()){
            editTextName?.setText(R.string.app_white_black)
            editTextLastName?.setText(R.string.app_white_black)
            editTextPetName?.setText(R.string.app_white_black)
        }

        /*edtViewNameLayout?.error = "Error: Ingresa tu nombre"
        edtViewApellidoLayout?.error = "Error: Ingresa tu apellido"
        edtViewMascotaLayout?.error = "Error: Ingresa el nombre de tu mascota"*/

        /*editText?.setText("")
        editText1?.setText("")
        editText2?.setText("")*/

        // Patron 2 exitoso
        /*txtViewGeneral?.visibility = View.VISIBLE
        txtViewGeneral?.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE
        txtViewGeneral?.text = "El formulario se envió exitosamente"*/

        // Patron 2 mostrar error necesitamos agregar el focus
        //txtViewGeneral?.setFocusable(true)
        //txtViewGeneral?.requestFocus()

        // Patron 1 es de material error (no se mueve el focus)
        // Patron 1 material estado de éxitoso con un pantalla nueva el focus va al textview del el formulario se envio exitosamente
        //edtViewNameLayout?.focusable = View.FOCUSABLE
        //edtViewNameLayout?.requestFocus()
    }
}