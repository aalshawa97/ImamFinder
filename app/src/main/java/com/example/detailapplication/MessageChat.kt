package com.example.detailapplication

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

class MessageChat(
    val messageText: String = "",
    val fromUid: String = "",
    @ServerTimestamp
    val sentAt: Date? = null
)