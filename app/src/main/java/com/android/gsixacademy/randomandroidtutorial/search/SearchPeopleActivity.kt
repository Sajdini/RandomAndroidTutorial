package com.android.gsixacademy.randomandroidtutorial.search

import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.gsixacademy.randomandroidtutorial.R
import com.android.gsixacademy.randomandroidtutorial.api.ServiceBuilder
import com.android.gsixacademy.randomandroidtutorial.api.TheMovieDbApi
import com.android.gsixacademy.randomandroidtutorial.api.models.PopularPeople
import com.android.gsixacademy.randomandroidtutorial.people.PeopleAdapter
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPeopleActivity:AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        button_search.setOnClickListener {

            val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)
            val call = request.getPopularPeople("8dd3a40cdacd660d79bce7c46bad942e")

            call.enqueue(object : Callback<PopularPeople> {
                override fun onResponse(call: Call<PopularPeople>, response: Response<PopularPeople>
                ) {
                    if (response.isSuccessful) {
                        val popularPeople = response.body()
                        val peopleList = popularPeople?.results

                        if (peopleList != null) {

                            var peopleAdapter = PeopleAdapter(peopleList) {}
                            recycler_view_search.layoutManager=GridLayoutManager(applicationContext,2)
                            recycler_view_search.adapter = peopleAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<PopularPeople>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}