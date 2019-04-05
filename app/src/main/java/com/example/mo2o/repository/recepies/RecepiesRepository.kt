package com.example.mo2o.repository.recepies

import com.example.mo2o.data.responses.RecepyResponse
import com.example.mo2o.repository.BaseRepository
import com.example.mo2o.repository.Result

class RecepiesRepository(private val api : RecepiesApi) : BaseRepository() {

    suspend fun  getRecepies(query: String) : Result<RecepyResponse>{
        val recepiesResponse = safeApiCall(
            call = {api.getRecepies(query).await()}
        )

        return recepiesResponse
    }

}