package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gallery.repository.ImagesRepository
import com.example.gallery.viewmodel.ImagesViewModel
import com.example.gallery.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class GalleryMainActivity : AppCompatActivity() {
    @Inject lateinit var imagesRepository: ImagesRepository
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagesAdapter = ImagesAdapter(ArrayList())
        recylerView.adapter = imagesAdapter
        val imagesViewModel = ViewModelProvider(this, viewModelFactory).get(ImagesViewModel::class.java)
        imagesViewModel.getImages()
        setupImagesObserver(imagesViewModel)
    }

    fun setupImagesObserver(imagesViewModel: ImagesViewModel) {
        imagesViewModel.imageList.observe(this, Observer {
            imagesAdapter.setItems(it)
        })
    }
}
