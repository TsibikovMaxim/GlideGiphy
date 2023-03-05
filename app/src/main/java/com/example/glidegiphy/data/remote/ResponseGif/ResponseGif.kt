package com.example.glidegiphy.data.remote.ResponseGif

data class ResponseGif(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)