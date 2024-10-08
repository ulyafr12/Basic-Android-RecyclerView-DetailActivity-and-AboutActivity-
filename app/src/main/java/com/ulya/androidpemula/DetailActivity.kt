package com.ulya.androidpemula

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Menyambungkan ikon arrowBack
        val arrowBack: ImageView = findViewById(R.id.arrowBack)

        // Menangani klik pada ikon back
        arrowBack.setOnClickListener {
            // Mengalihkan kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Tambahkan ini jika ingin menutup DetailActivity
        }

        val getData = intent.getParcelableExtra<DataClass>("android")
        if (getData != null) {
            val detailName: TextView = findViewById(R.id.detailName)
            val detailDesc: TextView = findViewById(R.id.detailDescription)
            val detailImage: ImageView = findViewById(R.id.detailImage)

            detailName.text = getData.dataName
            detailDesc.text = getData.dataDetailDescription
            detailImage.setImageResource(getData.dataDetailImage)
        }
    }
}