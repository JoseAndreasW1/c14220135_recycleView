package com.example.c14220135_recycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class adapterRevView (private val listWayang: ArrayList<wayang>) :
    RecyclerView.Adapter<adapterRevView.ListViewHolder>() {
    inner class ListViewHolder(itemView: View)  : RecyclerView.ViewHolder(itemView){
        var _namaWayang = itemView.findViewById<TextView>(R.id.namaWayang)
        var _karakterWayang = itemView.findViewById<TextView>(R.id.karakterWayang)
        var _deskripsiWayang = itemView.findViewById<TextView>(R.id.desktripsiWayang)
        var _gambarWayang = itemView.findViewById<ImageView>(R.id.gambarWayang)

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
     val view: View = LayoutInflater.from(parent.context)
         .inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var wayang = listWayang[position]
        holder._namaWayang.setText(wayang.nama)
        holder._karakterWayang.setText(wayang.karakter)
        holder._deskripsiWayang.setText(wayang.deskripsi)
        holder._gambarWayang.setImageResource(wayang.foto)
    }
}