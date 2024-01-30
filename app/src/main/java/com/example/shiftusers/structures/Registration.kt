package com.example.shiftusers.structures

import com.example.shiftusers.structures.serializers.DateSerializer
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Registration(
    @Serializable(with = DateSerializer::class)
    val date: Date,
    val age: Int
)
