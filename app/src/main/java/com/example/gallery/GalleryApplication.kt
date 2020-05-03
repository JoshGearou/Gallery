package com.example.gallery

import android.app.Application
import com.example.gallery.injection.module.component.AppComponent
import com.example.gallery.injection.module.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class GalleryApplication: Application(), HasAndroidInjector {

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any>? = activityDispatchingInjector

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()

        component.inject(this)
    }

    companion object {
        lateinit var component: AppComponent
    }
}