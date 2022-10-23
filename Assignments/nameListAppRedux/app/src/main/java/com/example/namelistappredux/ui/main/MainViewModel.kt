package com.example.namelistappredux.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var outputNames: MutableLiveData<String> = MutableLiveData()

    fun addName(name: String){
        if(!outputNames.value.isNullOrBlank()){
            outputNames.value = outputNames.getValue().toString()+"$name\n"
        }else{
            outputNames.value = "$name\n"
        }

    }

    fun getNames(): MutableLiveData<String> {
        return outputNames
    }

    fun clearNames(){
        outputNames.value = ""
    }
}

