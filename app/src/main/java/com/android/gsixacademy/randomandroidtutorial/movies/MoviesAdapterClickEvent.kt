package com.android.gsixacademy.randomandroidtutorial.movies

import com.android.gsixacademy.randomandroidtutorial.api.models.MovieResult

sealed class MoviesAdapterClickEvent {
    data class MoviesAdapterItemClicked (val movieResult: MovieResult):MoviesAdapterClickEvent()

}