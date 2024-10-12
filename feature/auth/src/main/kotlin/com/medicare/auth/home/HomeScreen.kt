package com.medicare.auth.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.medicare.database.model.Medicine


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToHomeDetail :(Medicine) -> Unit
){
    val state= viewModel.state.collectAsStateWithLifecycle()
     val userNameState = viewModel.userName.collectAsStateWithLifecycle()

    Home( state.value,
        onEvent = { event ->
            when (event) {
                HomeUiEvent.OnLoadData -> {

                }
                is HomeUiEvent.OnMedicineClick -> {
                    onNavigateToHomeDetail(event.medicine)
                }
            }

        },
        userName = userNameState.value
    )
}

@Composable
fun Home(
    state: HomeUiState,
    onEvent: (HomeUiEvent) ->Unit,
    userName :String
){
    Column( modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp))
    {
        Box ( modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Text(
                text = "${state.greeting}, $userName",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 14.dp)
            )
        }

        LazyColumn {
            items(state.medicine){ medicine ->
                Card(  modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onEvent(
                            HomeUiEvent.OnMedicineClick(
                                medicine
                            )
                        )
                    }

                ) {
                    Column( modifier = Modifier.padding(16.dp)) {
                        Text(text = medicine.name)
                        Text(text = "Dose: ${medicine.dose}")
                        Text(text = "Strength: ${medicine.strength}")
                    }
                }

            }
        }
    }

}