package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variable para gestionar la reproducción de audio
    private var mediaPlayer: MediaPlayer? = null
    // Variable para rastrear el estado actual de la música
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el MediaPlayer con el archivo de audio local
        // Asegúrate de que tu archivo de audio (ej. "musica.mp3") esté en res/raw
        mediaPlayer = MediaPlayer.create(this, R.raw.sweden)

        // Encontrar los botones en la interfaz de usuario
        val playButton: Button = findViewById(R.id.playButton)
        val pauseButton: Button = findViewById(R.id.pauseButton)
        val stopButton: Button = findViewById(R.id.stopButton)

        // Configurar el listener para el botón de Reproducir
        playButton.setOnClickListener {
            if (!isPlaying) {
                // Si la música no está reproduciéndose, empezar a reproducirla
                mediaPlayer?.start()
                isPlaying = true
            }
        }

        // Configurar el listener para el botón de Pausar
        pauseButton.setOnClickListener {
            if (isPlaying) {
                // Si la música se está reproduciendo, pausarla
                mediaPlayer?.pause()
                isPlaying = false
            }
        }

        // Configurar el listener para el botón de Detener
        stopButton.setOnClickListener {
            // Detener la reproducción
            mediaPlayer?.stop()
            // Reiniciar el MediaPlayer para que la próxima reproducción comience desde el inicio
            mediaPlayer?.prepareAsync()
            isPlaying = false
        }
    }

    // Liberar los recursos del MediaPlayer cuando la actividad se destruye
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
