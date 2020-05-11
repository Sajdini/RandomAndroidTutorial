package com.android.gsixacademy.randomandroidtutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.randomandroidtutorial.api.models.Car
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycleview_list_item.view.*
import java.util.*
//this is not an Activity class. This is a a custom adapter for a Recycler view list
//this shows how the item on a list should look like
class CarsAdapter(val itemList: ArrayList<Car>, val carsAdapterClickEvent: (CarsAdapterClickEvent) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycleview_list_item, parent, false))
    }
    //this shows the size of the list
    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(itemList[position], position)
    }
    //the function of a particular item in the list is built in here
    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bindData(itemModel: Car, position: Int) {
            Picasso.get().load(itemModel.imageResource).fit().fit().into(itemView.image_view_car)
//            itemView.image_view_car.setImageResource(itemModel.imageResource)
            itemView.text_view_title.text = itemModel.title
            itemView.text_view_description.text = itemModel.description
            itemView.image_view_favourite.setOnClickListener {
                var mySharedPreferences =
                    itemView.image_view_favourite.context.getSharedPreferences(
                        "MyFavourites",
                        Context.MODE_PRIVATE
                    )
                if (mySharedPreferences.contains("myFavourite_$position")) {

                    mySharedPreferences.edit().remove("myFavourite_$position").apply()
                    Picasso.get().load(R.drawable.icon_star).fit().fit()
                        .into(itemView.image_view_favourite)
                } else {
                    mySharedPreferences.edit().putInt("myFavourite_$position", position).apply()
                    Picasso.get().load(R.drawable.icon_star).fit().fit()
                        .into(itemView.image_view_favourite)
                }
            }


                var mySharedPreferences = itemView.image_view_favourite.context.getSharedPreferences("MyFavourites", Context.MODE_PRIVATE)
                if (mySharedPreferences.contains("myFavourite_$position")) {
                    Picasso.get().load(R.drawable.icon_star_white).fit().fit().into(itemView.image_view_favourite)
                }else {
                    mySharedPreferences.edit().putInt("myFavourite_$position",position).apply()
                    Picasso.get().load(R.drawable.icon_star).fit().fit()
                        .into(itemView.image_view_favourite)
                }
                itemView.constraint_car_main.setOnClickListener{
                    carsAdapterClickEvent.invoke(CarsAdapterClickEvent.CarsAdapterItemClicked(itemModel))

                }

        }
    }
}


