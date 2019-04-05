package com.example.mo2o.repository

import com.example.mo2o.repository.recepies.RecepiesApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory{
    private val BASE_URL = "http://www.recipepuppy.com/"

    private val recepiesClient = OkHttpClient().newBuilder().build()

    fun retrofit() : Retrofit = Retrofit.Builder().
                                client(recepiesClient).
                                baseUrl(BASE_URL).
                                addConverterFactory(GsonConverterFactory.create()).
                                addCallAdapterFactory(CoroutineCallAdapterFactory()).
                                build()

    val recepiesApi : RecepiesApi = retrofit().create(RecepiesApi::class.java)
}