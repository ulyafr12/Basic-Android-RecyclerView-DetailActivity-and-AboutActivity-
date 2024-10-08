package com.ulya.androidpemula

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.NameList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var nameList: Array<String>
    lateinit var descriptionList: Array<String>
    lateinit var detailDescription: Array<String>
    lateinit var detailImage: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var toolbar: Toolbar
    private lateinit var accountCircle: ImageView // Inisialisasi ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inisialisasi ImageView untuk accountCircle
        accountCircle = findViewById(R.id.accountCircle)

        // Menangani klik pada accountCircle
        accountCircle.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        imageList = arrayOf(
            R.drawable.scoups,
            R.drawable.jeonghan,
            R.drawable.joshua,
            R.drawable.jun,
            R.drawable.hoshi,
            R.drawable.wonwoo,
            R.drawable.woozi,
            R.drawable.the8,
            R.drawable.mingyu,
            R.drawable.dk,
            R.drawable.seungkwan,
            R.drawable.vernon,
            R.drawable.dino)

        nameList = arrayOf(
            "S.Coups",
            "Jeonghan",
            "Joshua",
            "Jun",
            "Hoshi",
            "Wonwoo",
            "Woozi",
            "The 8",
            "Mingyu",
            "Dokyeom",
            "Seungkwan",
            "Vernon",
            "Dino")

        descriptionList = arrayOf(
            "S.Coups adalah leader dan rapper Seventeen, dikenal karena karisma dan kepemimpinannya",
            "Jeonghan adalah vokalis Seventeen, dikenal dengan visualnya yang menawan dan suara lembutnya",
            "Joshua adalah vokalis Seventeen, dikenal dengan suara halus dan pesonanya yang sopan",
            "Jun adalah lead dancer dan vokalis Seventeen, dikenal dengan bakat menari dan karisma panggungnya",
            "Hoshi adalah main dancer dan koreografer Seventeen, dikenal karena energinya yang eksplosif dan keahlian dalam menciptakan koreografi",
            "Wonwoo adalah rapper dan vokalis Seventeen, dikenal dengan suara dalamnya dan gaya penampilan yang karismatik",
            "Woozi adalah vokalis utama dan produser Seventeen, dikenal karena bakat komposisi dan suaranya yang emosional",
            "The8 adalah dancer dan vokalis Seventeen, dikenal dengan gaya menari yang unik dan kemampuan berbicara dalam beberapa bahasa",
            "Mingyu adalah rapper dan visual Seventeen, dikenal dengan penampilan menawannya dan keterampilan memasaknya",
            "DK adalah vokalis utama Seventeen, dikenal dengan suara kuatnya dan kemampuan bernyanyi yang mengesankan",
            "Seungkwan adalah vokalis Seventeen, dikenal dengan suara yang emotif dan kepribadiannya yang ceria serta humoris",
            "Vernon adalah rapper dan penulis lagu Seventeen, dikenal dengan gaya uniknya dan kemampuannya dalam menciptakan lirik yang mendalam",
            "Dino adalah main dancer dan vokalis Seventeen, dikenal dengan bakat menarinya yang luar biasa dan energi yang tinggi di atas panggung",)

        detailDescription = arrayOf(
            getString(R.string.scoups),
            getString(R.string.jeonghan),
            getString(R.string.joshua),
            getString(R.string.jun),
            getString(R.string.hoshi),
            getString(R.string.wonwoo),
            getString(R.string.woozi),
            getString(R.string.minghao),
            getString(R.string.mingyu),
            getString(R.string.dk),
            getString(R.string.seungkwan),
            getString(R.string.vernon),
            getString(R.string.dino))

        detailImage = arrayOf(
            R.drawable.detail_scoups,
            R.drawable.detail_jeonghan,
            R.drawable.detail_joshua,
            R.drawable.detail_jun,
            R.drawable.detail_hoshi,
            R.drawable.detail_wonwoo,
            R.drawable.detail_woozi,
            R.drawable.detail_minghao,
            R.drawable.detail_mingyu,
            R.drawable.detail_dk,
            R.drawable.detail_seungkwan,
            R.drawable.detail_vernon,
            R.drawable.detail_dino)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()

        myAdapter = AdapterClass(dataList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun setSupportActionBar(toolbar: Toolbar?) {

    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], nameList[i], descriptionList[i], detailDescription[i], detailImage[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)

    }
}
