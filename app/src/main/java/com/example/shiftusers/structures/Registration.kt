package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class Registration(
    val date: String,
    val age: Int
)