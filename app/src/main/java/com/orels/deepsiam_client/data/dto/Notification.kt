package com.orels.deepsiam_client.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Notification(
    @PrimaryKey val id: String = "",
    @ColumnInfo val title: String = "",
    @ColumnInfo val body: String = "",
): DTO, Serializable {
    override val data: Map<String, Any>
        get() = mapOf("title" to title, "body" to body)
    
    companion object {
        fun toObject(data: Map<String, Any>?): Notification =
            Notification(
                id = data?.get("id") as String,
                title = data["title"] as String,
                body = data["body"] as String,
            )
    }
}