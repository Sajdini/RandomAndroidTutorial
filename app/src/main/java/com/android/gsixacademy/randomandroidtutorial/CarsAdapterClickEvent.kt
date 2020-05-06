package com.android.gsixacademy.randomandroidtutorial

sealed class CarsAdapterClickEvent {
    data class CarsAdapterItemClicked(var car: Car): CarsAdapterClickEvent()
}