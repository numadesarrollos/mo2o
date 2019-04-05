package com.example.mo2o.repository

import android.util.Log
import retrofit2.Response
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {

        val result : Result<T> = safeApiResult(call)

        return result

    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T>) : Result<T>{
        val response = call.invoke()
        if(response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - ${response.errorBody()?.string()}"))
    }
}