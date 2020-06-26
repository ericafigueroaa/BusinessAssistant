package com.example.businessassitant

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val datosRecibidos=intent.extras
        val nombre=datosRecibidos?.getString("nombre")
        val telefono=datosRecibidos?.getLong("telefono")

        Toast.makeText(this,"nombre: $nombre y telefono: $telefono: ",Toast.LENGTH_SHORT).show()

        button.setOnClickListener(){
            onBackPressed()
        }

        button3.setOnClickListener(){
            val intent= Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
    }

}