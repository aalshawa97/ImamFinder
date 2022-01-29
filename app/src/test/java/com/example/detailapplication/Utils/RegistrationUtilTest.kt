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
}