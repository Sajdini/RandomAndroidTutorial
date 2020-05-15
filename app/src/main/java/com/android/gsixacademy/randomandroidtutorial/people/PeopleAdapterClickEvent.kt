package com.android.gsixacademy.randomandroidtutorial.people

import com.android.gsixacademy.randomandroidtutorial.api.models.PersonResult

sealed class PeopleAdapterClickEvent {
    data class PeopleAdapterItemClicked(val personResult: PersonResult): PeopleAdapterClickEvent()
}