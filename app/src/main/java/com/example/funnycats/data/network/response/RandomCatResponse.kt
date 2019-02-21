package com.example.funnycats.data.network.response

import com.example.funnycats.data.network.RandomCat
import com.google.gson.annotations.SerializedName

data class RandomCatResponse(
    @SerializedName("")
    val response: List<RandomCat>
)
