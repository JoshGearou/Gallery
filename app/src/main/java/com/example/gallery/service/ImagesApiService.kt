package com.example.gallery.service

import com.example.gallery.model.ImagesMetaData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ImagesApiService {

    @GET("photos/")
    fun getImages(): Single<List<ImagesMetaData>>

    @GET("photos/random/")
    fun getRandomImage(): Single<ImagesMetaData>
}