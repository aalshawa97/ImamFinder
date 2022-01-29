package com.example.detailapplication.Utils

object ChatBotUtil {
    fun validateInput(botKey: String?): Boolean {
        return if (botKey != null) {
            true
        } else false
    }
}