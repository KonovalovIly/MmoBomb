package com.example.mmobomb.base.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseGameViewModel : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String>
        get() = _errorMessage

    protected fun processError(throwable: Throwable) {
        Log.e(BaseGameViewModel::class.java.name, throwable.toString())
        _errorMessage.postValue(throwable.message)
    }

    protected fun startLoad() {
        _isLoading.postValue(true)
    }

    protected fun <T> Result<T>.onEndLoad(): Result<T> {
        _isLoading.postValue(false)
        return this
    }
}