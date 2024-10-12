package com.medicare.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medicare.auth.util.Routes
import com.medicare.auth.util.UiEvent
import com.medicare.data.repository.UserRepository
import com.medicare.database.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState :StateFlow<LoginUiState> = _uiState

    private val _event = MutableSharedFlow<UiEvent>()
    val event =_event.asSharedFlow()

    fun onEvent(event: LoginUiEvent){
        when(event){

            LoginUiEvent.OnLoginClick -> {
               _uiState.value =_uiState.value.copy(isLoggedIn = true)
                viewModelScope.launch {
                    userRepository.upsertUser(User(userName = _uiState.value.userName))
                    _event.emit(UiEvent.Navigate(Routes.HOME))
                }
            }
            is LoginUiEvent.OnUserNameChange -> {
                _uiState.value = _uiState.value.copy(userName = event.username)
            }
        }
    }
}