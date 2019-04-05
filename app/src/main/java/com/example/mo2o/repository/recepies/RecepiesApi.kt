package com.example.mo2o.repository.recepies

import com.example.mo2o.data.responses.RecepyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecepiesApi {

    @GET("api/")
    fun getRecepies(@Query("q") query: String): Deferred<Response<RecepyResponse>>

}