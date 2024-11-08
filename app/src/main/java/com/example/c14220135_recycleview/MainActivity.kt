package com.example.c14220135_recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        _rvWayang = findViewById(R.id.rvWayang)

        fun SiapkanData(){
            _nama = resources.getStringArray(R.array.namaWayang)
            _karakter = resources.getStringArray(R.array.karakterUtamaWayang)
            _deskripsi = resources.getStringArray(R.array.deskripsiWayang)
            _gambar = resources.getStringArray(R.array.gambarWayang)
        }

        fun TambahData(){
            for(postion in _nama.indices){
                val data = wayang(
                    _gambar[postion],
                    _nama[postion],
                    _karakter[postion],
                    _deskripsi[postion]
                )
                arWayang.add(data)
            }
        }

        fun TampilkanData(){
            _rvWayang.layoutManager = GridLayoutManager(this,2)
            _rvWayang.adapter = adapterRevView(arWayang)
        }

        _rvWayang= findViewById<RecyclerView>(R.id.rvWayang)
        SiapkanData()
        TambahData()
        TampilkanData()

    }
    private lateinit var _nama: Array<String>
    private lateinit var _karakter: Array<String>
    private lateinit var _deskripsi: Array<String>
    private lateinit var _gambar: Array<String>

    private var arWayang = arrayListOf<wayang>()

    private lateinit var _rvWayang : RecyclerView

}