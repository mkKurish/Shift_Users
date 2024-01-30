package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class RandomUsersTimeZone(
    val offset: String,
    val description: String
)
