package com.android.gsixacademy.randomandroidtutorial

import com.android.gsixacademy.randomandroidtutorial.api.models.Car

sealed class CarsAdapterClickEvent {
    data class CarsAdapterItemClicked(var car: Car): CarsAdapterClickEvent()
}