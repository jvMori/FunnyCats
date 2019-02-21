package com.example.funnycats.data.network.response

data class RandomCat(
    val breeds: List<Any>,
    val id: String?,
    val url: String?
)