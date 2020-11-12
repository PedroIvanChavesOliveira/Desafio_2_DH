package com.example.splashactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val usersDatas: MutableLiveData<UserData> = MutableLiveData()

    fun setUserData(userData: UserData) {
        usersDatas.postValue(userData)
    }
}