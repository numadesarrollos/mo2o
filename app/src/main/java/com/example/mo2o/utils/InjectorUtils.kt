package com.example.mo2o.utils

import com.example.mo2o.repository.ApiFactory
import com.example.mo2o.repository.recepies.RecepiesRepository
import com.example.mo2o.ui.viewmodel.MainViewModelFactory

object InjectorUtils {

    fun providesMainViewModelFactory() : MainViewModelFactory {
        return MainViewModelFactory(providesRepository())
    }

    private fun providesRepository() : RecepiesRepository{
        return RecepiesRepository(ApiFactory.recepiesApi)
    }
}