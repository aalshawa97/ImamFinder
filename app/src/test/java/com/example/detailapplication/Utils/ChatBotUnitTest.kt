package com.example.detailapplication.Utils

import com.example.detailapplication.Utils.ChatBotUtil.validateInput
import com.example.detailapplication.Utils.RegistrationUtil.validateRegistrationInput
import com.example.detailapplication.activity.ChatBotActivity
import com.google.common.truth.Truth
import org.junit.Test

class ChatBotUnitTest {
    @Test
    fun `correct bot key returns true `(){
        //Assert(true, true)
        val result = ChatBotUtil.validateInput(
            "bot",
        )
        Truth.assertThat(result).isEqualTo(true)
        //assertThat(result).isFalse()
    }
}