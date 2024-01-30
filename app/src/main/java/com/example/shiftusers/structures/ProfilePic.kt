package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class ProfilePic(
    val large: String,
    val medium: String,
    val thumbnail: String
)
