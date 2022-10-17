package com.example.namelistapp.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var outputNames = ""

    fun addName(name: String){
        this.outputNames += "$name\n"
    }

    fun getNames():String{
        return outputNames
    }

    fun clearNames(){
        this.outputNames = ""
    }

}