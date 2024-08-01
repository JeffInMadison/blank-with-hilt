package com.jeffalexander.blankwithhilt.di

import com.jeffalexander.blankwithhilt.remote.RemoteApi
import com.jeffalexander.blankwithhilt.remote.RemoteService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.endpoint.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideRemoteApi(
        retrofit: Retrofit
    ) : RemoteApi {
        return retrofit.create(RemoteApi::class.java)
    }

    @Provides
    fun provideRemoteService(
        remoteApi: RemoteApi
    ) : RemoteService {
        return RemoteService()
    }
}