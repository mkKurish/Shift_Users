package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val number: Int,
    val name: String
)
