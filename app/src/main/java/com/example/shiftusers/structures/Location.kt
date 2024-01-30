package com.example.shiftusers.structures

import kotlinx.serialization.Serializable
import java.util.TimeZone

@Serializable
data class Location(
    val streetNum: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val cordLatitude: Double,
    val cordLongitude: Double,
    val tzOffset: Double,
    val tzDescription: String
)