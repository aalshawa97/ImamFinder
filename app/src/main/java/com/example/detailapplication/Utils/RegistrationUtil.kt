package com.example.detailapplication.Utils

import com.example.detailapplication.User

object RegistrationUtil {
    private val existingUser = listOf("Mohammad Farah", "moFarah")

    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ) : Boolean {
        if(username.isEmpty() || password.isEmpty()){
            return false
        }
        if(username in existingUser){
            return false
        }
        if(password != confirmedPassword)
        {
            return false
        }
        if(password.count{it.isDigit() } < 2)
        {
            return false
        }
        return true
    }

}