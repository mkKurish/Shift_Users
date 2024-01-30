package com.example.shiftusers.dataUtils.internetUtils

import com.example.shiftusers.structures.serializers.BigIntegerSerializer
import kotlinx.serialization.Serializable
import java.math.BigInteger

@Serializable
data class ResponseInfo(
    @Serializable(with = BigIntegerSerializer::class)
    val seed: BigInteger,
    val results: Int,
    val page: Int,
    val version: String
)