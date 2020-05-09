package com.example.gallery.injection.module.component

import com.example.gallery.GalleryApplication
import com.example.gallery.injection.module.ActivityModule
import com.example.gallery.injection.module.ImagesModule
import com.example.gallery.injection.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component (modules = [AndroidSupportInjectionModule::class, ActivityModule::class, ImagesModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(app: GalleryApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: GalleryApplication): Builder

        fun build(): AppComponent
    }
}