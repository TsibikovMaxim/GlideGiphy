package com.example.glidegiphy.data.remote

import com.example.glidegiphy.data.remote.ResponseGif.ResponseGif
import retrofit2.http.GET
import retrofit2.http.Query

interface GifApi {
    companion object {
        const val BASE_URL = "https://api.giphy.com/v1/gifs/"
    }

    @GET("search?api_key=Qzy3tMRglY9kBivTcYBWxxTjg9vfnNw1&&limit=25&offset=0&rating=g&lang=en")
    suspend fun getData(@Query("q") searchInfo : String) : ResponseGif
}