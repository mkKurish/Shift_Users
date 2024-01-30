package com.example.shiftusers.structures

import com.example.shiftusers.structures.serializers.DateSerializer
import kotlinx.serialization.Serializable
import java.util.Calendar
import java.util.Date

@Serializable
class ShiftUser(
    val gender: Genders,

    val nameTitle: Titles,
    val firstName: String,
    val lastName: String,

    val location: Location,

    val email: String,
    val login: UserLogin,
    @Serializable(with = DateSerializer::class)
    val dateOfBirth: Date,

    val registration: Registration,

    val phone: String,
    val cell: String,

    val id: Identification,

    val picture: ProfilePic,

    val nat: String,
) {
    val age: Int
        get() {
            val cal1 = Calendar.getInstance()
            val cal2 = Calendar.getInstance()
            cal1.time = Date()
            cal2.time = dateOfBirth
            return cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)
        }
}