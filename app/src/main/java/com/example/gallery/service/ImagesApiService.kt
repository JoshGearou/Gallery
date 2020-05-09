package com.example.gallery.service

import com.example.gallery.model.ImagesMetaData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImagesApiService {

    @GET("photos/")
    fun getImages(): Single<List<ImagesMetaData>>

    @Headers
    @GET("photos/random/")
    fun getRandomImage(): Single<ImagesMetaData>
}