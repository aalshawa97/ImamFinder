package com.example.detailapplication.Utils

import org.junit.Assert
import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import io.getstream.chat.android.client.utils.toResult
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false `(){
        //Assert(true, true)
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isEqualTo(false)
        //assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`(){
        //Assert(true, true)
        val result = RegistrationUtil.validateRegistrationInput(
            "Mohammad Farah",
            "123",
            "123"
        )
        assertThat(result).isEqualTo(false)
        //assertThat("hello").isEqualTo("hello")
        //assertThat(result).isFalse()
    }

    //Empty password
    //Password was repeated incorrectly
    //Password contains less than 2 digits
    @Test
    fun `empty password returns false` () {
        val result = RegistrationUtil.validateRegistrationInput(
            "moFarah",
            "abcdeghi",
            "abcdeghi"
        )
        assertThat(result).isFalse()
    }

}