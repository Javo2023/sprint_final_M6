package com.example.sprint_final_m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint_final_m6.data.Repository
import com.example.sprint_final_m6.data.remote.TelephoneRetrofit
import kotlinx.coroutines.launch

class PhoneVM (application: Application):AndroidViewModel(application){
    private val repositorio:Repository

    init{
        val api = TelephoneRetrofit.getRetrofitTelephone()
        repositorio= Repository(api)

    }

    fun getAllTelephones() = viewModelScope.launch{
        repositorio.loadTelephone()

    }

}