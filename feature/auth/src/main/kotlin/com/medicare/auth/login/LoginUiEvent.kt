package com.medicare.auth.login

sealed class LoginUiEvent  {
        data object  OnLoginClick : LoginUiEvent()
    data class OnUserNameChange(val username:String) :LoginUiEvent()
}