package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1. Encontrar la ImageView por su ID
        val imageView: ImageView = findViewById(R.id.imageView)

        // 2. Establecer el listener de clic para la imagen
        imageView.setOnClickListener {
            // 3. Crear y mostrar el Toast con el mensaje personalizado
            Toast.makeText(this, "¡La imagen ha sido clickeada!", Toast.LENGTH_SHORT).show()
        }
    }
}
