package com.numadesarrollos.recepysearcher.utils

import com.numadesarrollos.recepysearcher.repository.ApiFactory
import com.numadesarrollos.recepysearcher.repository.recepies.RecepiesRepository
import com.numadesarrollos.recepysearcher.ui.viewmodel.MainViewModelFactory

object InjectorUtils {

    fun providesMainViewModelFactory() : MainViewModelFactory {
        return MainViewModelFactory(providesRepository())
    }

    private fun providesRepository() : RecepiesRepository{
        return RecepiesRepository(ApiFactory.recepiesApi)
    }
}