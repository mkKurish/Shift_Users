package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class DoB(
    val date: String,
    val age: Int
)
