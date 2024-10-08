package com.ulya.androidpemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulya.androidpemula.DataClass

class AdapterClass(
    private val dataList: ArrayList<DataClass>
) : RecyclerView.Adapter<AdapterClass.ViewHolder>() {

    var onItemClick: ((DataClass) -> Unit)? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.imageview)
        val rvName: TextView = itemView.findViewById(R.id.name)
        val rvDescription: TextView = itemView.findViewById(R.id.description)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(dataList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.imageResource)
        holder.rvName.text = currentItem.dataName
        holder.rvDescription.text = currentItem.dataDescription
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
