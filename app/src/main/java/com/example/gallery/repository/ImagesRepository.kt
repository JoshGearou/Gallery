package com.example.gallery.repository

import com.example.gallery.ImagesData
import com.example.gallery.service.ImagesApiService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepository @Inject constructor() {

    @Inject
    lateinit var imagesApiService: ImagesApiService

    fun getImages(): Single<List<ImagesData>> {
        return imagesApiService.getImages()
            .map {
                val images = ArrayList<ImagesData>()
                it.forEach {
                    images.add(ImagesData(it.id, it.description, it.urls?.regular))
                }
                return@map images
            }
    }
}