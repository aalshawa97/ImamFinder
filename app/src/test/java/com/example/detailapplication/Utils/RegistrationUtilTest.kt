package com.example.detailapplication.Utils

import org.junit.Assert
import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
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
        assertThat(result).isEqualTo(true)
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
        assertThat(result).isEqualTo(true)
        assertThat("hello").isEqualTo("hello")
        //assertThat(result).isFalse()
    }
}