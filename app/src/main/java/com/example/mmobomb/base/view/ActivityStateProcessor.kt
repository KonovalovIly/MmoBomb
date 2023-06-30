package com.example.mmobomb.base.view

interface ActivityStateProcessor {

    fun processLoading(state: Boolean)

    fun processError(message: String, onReloadPage: () -> Unit)
}