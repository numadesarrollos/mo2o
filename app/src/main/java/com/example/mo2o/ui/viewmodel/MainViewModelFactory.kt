package com.example.mo2o.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mo2o.repository.recepies.RecepiesRepository

class MainViewModelFactory(private val recepiesRepository: RecepiesRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(recepiesRepository) as T
    }
}