package com.android.gsixacademy.randomandroidtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycleview_list_item.view.*
import java.util.*
//this is not an Activity class. This is a a custom adapter for a Recycler view list
//this shows how the item on a list should look like
class CarsAdapter(val itemList: ArrayList<Car>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycleview_list_item, parent, false))
    }
    //this sets the size of a list
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(itemList[position])
    }
    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(itemModel: Car) //Car is inherited from the class CAR
        {
            itemView.image_view_car.setImageResource(itemModel.imageResource)
            itemView.text_view_title.text = itemModel.tittle
            itemView.text_view_description.text=itemModel.description
        }
    }
}


