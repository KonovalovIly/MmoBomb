package com.example.mmobomb.base.view

import com.example.mmobomb.base.model.ConnectionStatus
import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {

    fun observe(): Flow<ConnectionStatus>

    fun isConnected(): Boolean
}