package com.example.shiftusers.structures

import kotlinx.serialization.Serializable

@Serializable
class ShiftUser(
    val gender: Genders,
    val name: Name,
    val location: Location,
    val email: String,
    val login: UserLogin,
    val dob: DoB,
    val registered: Registration,
    val phone: String,
    val cell: String,
    val id: Identification,
    val picture: ProfilePic,
    val nat: String,
)