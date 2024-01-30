package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val title: Titles,
    val first: String,
    val last: String
)
