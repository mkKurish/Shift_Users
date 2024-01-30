package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class Identification(
    val name: String,
    val value: String
)
