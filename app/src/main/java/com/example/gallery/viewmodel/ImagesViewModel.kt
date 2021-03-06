package com.example.gallery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallery.ImagesData
import com.example.gallery.repository.ImagesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ImagesViewModel @Inject constructor(private val imagesRepository: ImagesRepository) : ViewModel() {
    val imageList = MutableLiveData<List<ImagesData>>()

    fun getImages() {
        imagesRepository.getImages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                imageList.postValue(it)
            },
                { error ->
                    println(error)
                }
            )
    }
}