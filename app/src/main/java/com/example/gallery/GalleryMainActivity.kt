package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.gallery.repository.ImagesRepository
import com.example.gallery.viewmodel.ImagesViewModel
import com.example.gallery.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class GalleryMainActivity : AppCompatActivity() {
    @Inject lateinit var imagesRepository: ImagesRepository
    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imagesViewModel = ViewModelProvider(this, viewModelFactory).get(ImagesViewModel::class.java)
        imagesViewModel.imageList.observe(this, Observer {
            Glide.with(this).load(it.get(0).url).into(iv_image)
        })
        imagesViewModel.getImages()
    }
}
