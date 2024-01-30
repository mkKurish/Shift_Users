package com.example.shiftusers.structures

import com.example.shiftusers.structures.serializers.PostcodeSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    @Serializable(with = PostcodeSerializer::class)
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: RandomUsersTimeZone
)