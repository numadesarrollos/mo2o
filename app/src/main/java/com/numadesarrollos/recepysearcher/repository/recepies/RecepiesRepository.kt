package com.numadesarrollos.recepysearcher.repository.recepies

import com.numadesarrollos.recepysearcher.data.responses.RecepyResponse
import com.numadesarrollos.recepysearcher.repository.BaseRepository
import com.numadesarrollos.recepysearcher.repository.Result

class RecepiesRepository(private val api : RecepiesApi) : BaseRepository() {

    suspend fun  getRecepies(query: String) : Result<RecepyResponse>{
        val recepiesResponse = safeApiCall(
            call = {api.getRecepies(query).await()}
        )

        return recepiesResponse
    }

}