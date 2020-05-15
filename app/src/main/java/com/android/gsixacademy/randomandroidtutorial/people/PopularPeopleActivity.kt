package com.android.gsixacademy.randomandroidtutorial.people

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.randomandroidtutorial.R
import com.android.gsixacademy.randomandroidtutorial.api.ServiceBuilder
import com.android.gsixacademy.randomandroidtutorial.api.TheMovieDbApi
import com.android.gsixacademy.randomandroidtutorial.api.models.PopularPeople
import kotlinx.android.synthetic.main.activity_recycle_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularPeopleActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        val request= ServiceBuilder.buildService(TheMovieDbApi::class.java)
        val call= request.getPopularPeople("8dd3a40cdacd660d79bce7c46bad942e")

        call.enqueue(object : Callback<PopularPeople> {
            override fun onResponse(
                call: Call<PopularPeople>,
                response: Response<PopularPeople>
            ) {
                if (response.isSuccessful) {
                    val popularPeople = response.body()
                    val peopleList = popularPeople?.results

                    if (peopleList != null) {

                        var peopleAdapter=PeopleAdapter(peopleList){}
                        recycler_view_activities.adapter=peopleAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<PopularPeople>, t: Throwable) {
                // show the error
            }
        })

    }
    }