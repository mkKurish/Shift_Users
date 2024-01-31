package com.example.shiftusers.dataUtils.internetUtils

import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class ResponseInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)