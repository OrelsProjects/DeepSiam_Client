package com.orels.deepsiam_client.data.remote.repository

import com.orels.deepsiam_client.data.dto.Notification

interface Repository {
    suspend fun getNotifications(): List<Notification>
}