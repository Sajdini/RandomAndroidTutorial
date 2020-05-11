package com.android.gsixacademy.randomandroidtutorial.api

import com.android.gsixacademy.randomandroidtutorial.api.models.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("/3/movie/popular")
    fun getpPopularMovies(@Query("api_key")key:String): Call<PopularMovies>
}