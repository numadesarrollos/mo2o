package com.example.mo2o.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mo2o.data.Recepy
import com.example.mo2o.repository.Result
import com.example.mo2o.repository.recepies.RecepiesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel (val recepiesRepository: RecepiesRepository) : ViewModel() {

    val parentJob = Job()
    val coroutineContext: CoroutineContext = parentJob + Dispatchers.Default
    val scope = CoroutineScope(coroutineContext)
    val recepiesLiveData = MutableLiveData<List<Recepy>>()
    val errorDialog = MutableLiveData<String>()


    fun getRecepies(query: String) {
        scope.launch {
            val recepies = recepiesRepository.getRecepies(query)
            when(recepies){
                is Result.Success -> recepiesLiveData.postValue(recepies.data.results)
                is Result.Error -> errorDialog.postValue(recepies.exception.message)
            }
        }
    }
}