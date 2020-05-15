package com.android.gsixacademy.randomandroidtutorial.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.randomandroidtutorial.R
import com.android.gsixacademy.randomandroidtutorial.api.models.PersonResult
import com.android.gsixacademy.randomandroidtutorial.movies.MoviesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.people_list_item.view.*

class PeopleAdapter ( val itemList: ArrayList<PersonResult>, val peopleAdapterClickEvent: (PeopleAdapterClickEvent) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>()

    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_recycle_view, parent, false)
                )
    }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val myViewHolder = holder as PeopleAdapter.MyViewHolder
            myViewHolder.bindData(itemList[position], position)
        }

            inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                fun bindData(itemModel: PersonResult, position: Int) {
                    Picasso.get().load("https://image.tmdb.org/t/p/w500/${itemModel.profile_path}").fit().fit().into(itemView.image_view_profile)
                    itemView.text_view_name.text = itemModel.name
                    itemView.text_view_popularity.text = itemModel.popularity
                }
            }
        }