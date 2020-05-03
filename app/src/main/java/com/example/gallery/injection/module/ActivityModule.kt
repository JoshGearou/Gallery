package com.example.gallery.injection.module

import com.example.gallery.GalleryMainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {


    @ContributesAndroidInjector
    abstract fun bindGalleryMainActivity(): GalleryMainActivity
}