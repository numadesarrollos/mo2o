package com.numadesarrollos.recepysearcher.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.numadesarrollos.recepysearcher.repository.recepies.RecepiesRepository

class MainViewModelFactory(private val recepiesRepository: RecepiesRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(recepiesRepository) as T
    }
}