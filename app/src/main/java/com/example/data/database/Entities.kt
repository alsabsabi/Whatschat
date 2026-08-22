package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val avatarId: String,
    val statusText: String,
    val isCurrentUser: Boolean = false,
    val lastSeenTimestamp: Long = System.currentTimeMillis(),
    val isOnline: Boolean = false
)

@Entity(tableName = "chats")
data class ChatEntity(
    @PrimaryKey val id: String,
    val contactName: String,
    val contactAvatarId: String,
    val lastMessage: String,
    val lastMessageTimestamp: Long,
    val unreadCount: Int = 0,
    val isPinned: Boolean = false,
    val isMuted: Boolean = false,
    val isArchived: Boolean = false
)

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey val id: String,
    val chatId: String,
    val senderId: String,
    val content: String,
    val timestamp: Long,
    val type: String = "TEXT", // TEXT, IMAGE, AUDIO, LOCATION, CONTACT
    val mediaUrl: String? = null,
    val audioDurationSeconds: Int = 0,
    val isDelivered: Boolean = true,
    val isRead: Boolean = false,
    val isSentByMe: Boolean = true,
    val reactionEmoji: String? = null,
    val replyToMessageId: String? = null
)

@Entity(tableName = "stories")
data class StoryEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val userName: String,
    val userAvatarId: String,
    val contentText: String? = null,
    val mediaUrl: String? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val isViewed: Boolean = false
)

@Entity(tableName = "call_logs")
data class CallLogEntity(
    @PrimaryKey val id: String,
    val contactName: String,
    val contactAvatarId: String,
    val timestamp: Long,
    val isVideo: Boolean,
    val isIncoming: Boolean,
    val isMissed: Boolean,
    val durationSeconds: Int = 0
)
