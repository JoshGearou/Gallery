package com.example.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.image.view.*

class ImagesAdapter(private var data: ArrayList<ImagesData>): RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = holder.item
        item.layout(0,0,0,0)
        Glide.with(item.context)
            .load(data[position].url)
            .into(item.iv_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setItems(imagesData: List<ImagesData>) {
        imagesData.forEach {
            data.add(it)
        }

        notifyDataSetChanged()
    }

    class MyViewHolder(val item: View): RecyclerView.ViewHolder(item)

}