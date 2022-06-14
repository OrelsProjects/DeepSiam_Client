package com.orels.deepsiam_client.presentation.mainscreen_user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orels.deepsiam_client.data.remote.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    var state by mutableStateOf(MainScreenState())
    private val _isRefreshing: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    fun onStart() {
        getNotifications()
    }

    fun refresh() {
        getNotifications()
    }

    private fun getNotifications() {
        viewModelScope.launch {
            val notifications = repository.getNotifications()
            state = state.copy(notifications = notifications)
        }
    }
}