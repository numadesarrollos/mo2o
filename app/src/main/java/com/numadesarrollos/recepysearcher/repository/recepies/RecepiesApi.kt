package com.numadesarrollos.recepysearcher.repository.recepies

import com.numadesarrollos.recepysearcher.data.responses.RecepyResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecepiesApi {

    @GET("api/")
    fun getRecepies(@Query("q") query: String): Deferred<Response<RecepyResponse>>

}