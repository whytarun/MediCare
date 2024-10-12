package com.medicare.auth.login

data class LoginUiState(
    val userName:String ="",
    val isLoggedIn:Boolean = false,
    val errorMessage :String? = null
)
