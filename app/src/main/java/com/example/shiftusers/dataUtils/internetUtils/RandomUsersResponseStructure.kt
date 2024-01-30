package com.example.shiftusers.dataUtils.internetUtils

import com.example.shiftusers.structures.ShiftUser
import kotlinx.serialization.Serializable

@Serializable
data class RandomUsersResponseStructure(
    val results: List<ShiftUser>,
    val info: ResponseInfo
)