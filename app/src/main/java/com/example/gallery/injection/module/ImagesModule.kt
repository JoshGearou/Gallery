package com.example.gallery.injection.module

import com.example.gallery.service.ImagesApiService
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class ImagesModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder().addInterceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .addHeader(
                    "Authorization",
                    "Client-ID " + "MFnJZZvk6YawEs2jMQBrIuKvcrOSik--srIJwRUZQos"
                )
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideImagesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton fun provideImagesApiService(retrofit: Retrofit): ImagesApiService {
        return retrofit.create(ImagesApiService::class.java)
    }
}