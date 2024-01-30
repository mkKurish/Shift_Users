package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val coordinates: Coordinates,
    val timezone: RandomUsersTimeZone
)