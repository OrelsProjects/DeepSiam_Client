package com.orels.deepsiam_client.data.remote.repository.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.orels.deepsiam_client.data.dto.Notification
import com.orels.deepsiam_client.data.remote.repository.Repository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepostiry @Inject constructor() : Repository {
    private val db = FirebaseFirestore.getInstance()

    override suspend fun getNotifications(): List<Notification> {
        return try {
            val documents = Collections.Notifications.get()
                .get().await().documents
            return documents.map { it.toObject(Notification::class.java)!! }
        } catch (ex: Exception) {
            var x = ex
            emptyList()
        }
    }

    private fun Collections.get(): CollectionReference = db.collection(value)

    private enum class Collections(val value: String) {
        Notifications("notifications"),
    }

}