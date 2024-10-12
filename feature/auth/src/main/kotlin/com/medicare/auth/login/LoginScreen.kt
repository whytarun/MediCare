package com.medicare.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.medicare.auth.util.UiEvent


@Composable
fun LoginScreen(viewModel: LoginViewModel,
                onNavigateToHome: () -> Unit) {

   val uiState= viewModel.uiState.collectAsStateWithLifecycle()
    // collect events
    LaunchedEffect(key1 = viewModel) {
        viewModel.event.collect{ event ->
            when(event){
                is UiEvent.Navigate-> {
                    onNavigateToHome()
                }

                is UiEvent.ShowSnackbar -> {

                }
                is UiEvent.ShowToast -> {

                }

            }

        }
    }

    Login(state = uiState.value,
          onEvent = {viewModel.onEvent(it) }
    )
}

@Composable
fun Login(
    state: LoginUiState,
    onEvent: (LoginUiEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = state.userName,
            onValueChange = { onEvent(LoginUiEvent.OnUserNameChange(it)) },
            label = { Text( "Enter Username")},
            modifier = Modifier.testTag("usernameTextField")
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onEvent(LoginUiEvent.OnLoginClick) }) {
                Text(text = "Login")
        }
    }
}