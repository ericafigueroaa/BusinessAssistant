package com.example.businessassitant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*
import java.util.*

class RegistroActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Log.d("OnCreate","ok")

        //var options_spiner = arrayOf("Medellín","Bogotá","Manizales","Cali","Barranquilla")


        //val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options_spiner )


        val adapter =ArrayAdapter.createFromResource(this,R.array.ciudades,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        sp_cuidades.adapter= adapter

        var ciudad =""
        sp_cuidades.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent:AdapterView<*>, view: View, position: Int, id: Long){
                // Display the selected item text on text view
                ciudad = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }


        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes =c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        iv_calendar.setOnClickListener{
            val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener { _:DatePicker, mYear:Int, mMonth:Int, mDay: Int ->
                tvFecha.setText(""+mDay+"/"+(mMonth+1)+"/"+mYear)
            },ano,mes,dia)
            dpd.show()
        }
        btRegistrar.setOnClickListener {
            val nombre = et_Nombre.text.toString()
            val correo = et_Correo.text.toString()
            val telefono:String=et_Telefono.text.toString()
            val contra:String=et_Contrasena.text.toString()
            val rcontra:String=et_Rcontrasena.text.toString()
            var genero:String= rb_Maculino.text.toString()
            if(rb_Femenino.isChecked){
                genero=rb_Femenino.text.toString()
            }

            var hobbies =""

            if(cb_viajar.isChecked)
                hobbies=hobbies+ cb_viajar.text.toString()+ " "

            if(cb_leer.isChecked)
                hobbies=hobbies+ cb_leer.text.toString()+ " "

            if(cb_bailar.isChecked)
                hobbies=hobbies+ cb_bailar.text.toString()+ " "

            if(cb_cantar.isChecked)
                hobbies=hobbies+ cb_cantar.text.toString() + " "

            val fecha :String = tvFecha.text.toString()

            // checkiar
            if(nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contra.isEmpty() || rcontra.isEmpty() || fecha.isEmpty()){
                Toast.makeText(this,"Por favor llenar todos los campos",Toast.LENGTH_SHORT).show()
                if (nombre.isEmpty()) {
                    et_Nombre.error = "Este campo no puede estar vacio"
                }

                if (correo.isEmpty()) {
                    et_Correo.error = "Este campo no puede estar vacio"
                }

                if (telefono.isEmpty()) {
                    et_Telefono.error = "Este campo no puede estar vacio"
                }

                if (contra.isEmpty()) {
                    et_Contrasena.error = "Este campo no puede estar vacio"
                }

                if (rcontra.isEmpty()) {
                    et_Rcontrasena.error = "Este campo no puede estar vacio"
                }
            }
            else
            {
                if(contra != rcontra)
                    Toast.makeText(this,"Contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                else{
                    tvResultado.text="Nombre: " + nombre +
                            "\nCorreo: " + correo+
                            "\nTelefono: " + telefono+
                            "\nGenero: " + genero+
                            "\nHobbies: " + hobbies+
                            "\nFecha de nacimiento: " + fecha+
                            "\nCiudad de Nacimiento: " + ciudad}
            }
        }

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_actividad2){
            Log.d("Menu", "presionado el menu1")
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
            intent.putExtra("nombre",et_Nombre.text.toString())
            intent.putExtra("telefono",et_Telefono.text.toString())

        }else{
            Log.d("Menu", "presionado el menu2")
            val intent=Intent(this,SplashActivity::class.java)
            startActivity(intent)
        }



        return super.onOptionsItemSelected(item)
    }


    override fun onStart() {
        super.onStart()
        Log.d("onStart","ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume","ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","ok")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy","ok")
    }
}




