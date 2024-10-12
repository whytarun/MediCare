package com.medicare.auth.util

 sealed class UiEvent {
     data class ShowToast(val message: String) : UiEvent()
      data class Navigate(val route: String) : UiEvent()
     data class ShowSnackbar(
         val message: String,
         val action: String? = null
     ): UiEvent()

 }