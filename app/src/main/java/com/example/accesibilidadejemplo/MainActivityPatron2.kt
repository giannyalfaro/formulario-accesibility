package com.example.accesibilidadejemplo

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivityPatron2 : AppCompatActivity() {

    private var buttonSend: AppCompatButton? = null
    private var edtViewNameLayout:TextInputLayout? = null
    private var edtViewApellidoLayout:TextInputLayout? = null
    private var edtViewMascotaLayout:TextInputLayout? = null

    private var editText:TextInputEditText? = null
    private var editText1:TextInputEditText? = null
    private var editText2:TextInputEditText? = null

    private var txtViewGeneral:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_patron_2)
        buttonSend = findViewById<View>(R.id.btnEnviar) as AppCompatButton
        edtViewNameLayout = findViewById<View>(R.id.edtViewName) as TextInputLayout
        edtViewApellidoLayout = findViewById<View>(R.id.edtViewApellido) as TextInputLayout
        edtViewMascotaLayout = findViewById<View>(R.id.edtViewMascota) as TextInputLayout

        editText = findViewById<View>(R.id.edit_text) as TextInputEditText
        editText1 = findViewById<View>(R.id.edit_text1) as TextInputEditText
        editText2 = findViewById<View>(R.id.edit_text2) as TextInputEditText

        editText!!.addTextChangedListener(object : TextWatcher {

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

        editText1!!.addTextChangedListener(object : TextWatcher {

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

        editText2!!.addTextChangedListener(object : TextWatcher {

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

    fun showMessage(errorNumber:Int){
        txtViewGeneral?.visibility = View.VISIBLE
        txtViewGeneral?.isFocusable = true
        txtViewGeneral?.requestFocus()
        txtViewGeneral?.setText("El formulario tiene " + errorNumber + " error(es)")
        txtViewGeneral?.setTextColor(Color.RED)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendData(view: View) {

        var errorNumber = 0

        //Patron 2 mostrar error necesitamos agregar el focus
        if(editText?.text!!.isEmpty()){
            edtViewNameLayout?.error = "Error: Ingresa tu nombre"
            errorNumber++
            showMessage(errorNumber)
        }else{
            edtViewNameLayout?.error = ""
        }

        if(editText1?.text!!.isEmpty()){
            edtViewApellidoLayout?.error = "Error: Ingresa tu apellido"
            errorNumber++
            showMessage(errorNumber)
        }else{
            edtViewApellidoLayout?.error = ""
        }

        if(editText2?.text!!.isEmpty()){
            edtViewMascotaLayout?.error = "Error: Ingresa el nombre de tu mascota"
            errorNumber++
            showMessage(errorNumber)
        }else{
            edtViewMascotaLayout?.error = ""
        }

        if(editText?.text!!.isNotEmpty() && editText1?.text!!.isNotEmpty() &&
            editText2?.text!!.isNotEmpty()){
            editText?.setText(R.string.app_white_black)
            editText1?.setText(R.string.app_white_black)
            editText2?.setText(R.string.app_white_black)

            // Patron 2 exitoso
            txtViewGeneral?.visibility = View.VISIBLE
            txtViewGeneral?.isFocusable = true
            txtViewGeneral?.requestFocus()
            txtViewGeneral?.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE
            txtViewGeneral?.text = "El formulario se envió exitosamente"
            txtViewGeneral?.setTextColor(Color.GREEN)
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

        // Patron 1 es de material error (no se mueve el focus)
        // Patron 1 material estado de éxitoso con un pantalla nueva el focus va al textview del el formulario se envio exitosamente
        //edtViewNameLayout?.focusable = View.FOCUSABLE
        //edtViewNameLayout?.requestFocus()
    }
}