package com.example.sentientwatcher.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object{
        private var outputText: MutableLiveData<String> = MutableLiveData()

        fun addToOutputText(stateStatus: String){
            if(!outputText.value.isNullOrBlank()) {
                outputText.value = "$stateStatus \n ${outputText.value.toString()}"
            } else {
                outputText.value = stateStatus
            }
        }
    }

    fun getOutput(): MutableLiveData<String>{
        return outputText
    }

}