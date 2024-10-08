package com.ulya.androidpemula

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var emailTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about) // Mengatur layout ke activity_about.xml

        // Menyambungkan ikon arrowBack
        val arrowBack: ImageView = findViewById(R.id.arrowBack)

        // Menangani klik pada ikon back
        arrowBack.setOnClickListener {
            // Mengalihkan kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Tambahkan ini jika ingin menutup DetailActivity
        }

        // Inisialisasi komponen UI
        profileImage = findViewById(R.id.profileImage)
        nameTextView = findViewById(R.id.nameTextView)
        emailTextView = findViewById(R.id.emailTextView)

        // Jika Anda ingin mengubah nama atau email melalui kode, Anda bisa melakukannya di sini.
        // Misalnya:
        nameTextView.text = "Ulya Faza Razak"
        emailTextView.text = "a134b4kx4374@bangkit.academy"
    }
}
