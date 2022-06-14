package com.orels.deepsiam_client.presentation.mainscreen_user

import com.orels.deepsiam_client.data.dto.Notification

data class MainScreenState(
    val notifications: List<Notification> = emptyList()
)