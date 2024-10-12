package com.medicare.auth.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.medicare.auth.util.Routes
import com.medicare.auth.util.UiEvent
import com.medicare.auth.util.getDemoMedications
import com.medicare.data.repository.MedicineRepository
import com.medicare.data.repository.UserRepository
import com.medicare.database.model.Medicine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val medicineRepository: MedicineRepository
) :ViewModel() {

     private val _state = MutableStateFlow(HomeUiState())
    val state :StateFlow<HomeUiState> =_state.asStateFlow()

    private val _event = MutableSharedFlow<UiEvent>()
    val event = _event.asSharedFlow()

    private val _userName = MutableStateFlow<String>("")
    val userName: StateFlow<String> =_userName


    init {
        onEvent(HomeUiEvent.OnLoadData)
        viewModelScope.launch {
            val user = userRepository.getUser()
            _userName.value = user?.userName ?: "Guest"
            insertDemoMedications()
        }
    }

    fun onEvent(event: HomeUiEvent){
        when(event){
            HomeUiEvent.OnLoadData -> {
                val medicine = getDemoMedications()
                _state.value = _state.value.copy(
                    greeting = getGreetingMessage(),
                    medicine =medicine
                )

            }
            is HomeUiEvent.OnMedicineClick -> {
                    viewModelScope.launch {
                        //medicineRepository.upsertMedicine(event.medicine)
                        _event.emit(UiEvent.Navigate(Routes.HOME_DETAIL + "/${event.medicine.id}"))
                    }
            }
        }
    }

    private fun getGreetingMessage():String {
        val currentHour = LocalTime.now().hour
        return when {
            currentHour in 6..1 -> "Good Morning"
            currentHour in 12.. 17 -> "Good Afternoon"
            else -> "Good Evening"
        }
    }

    private suspend fun insertDemoMedications() {
        val medications = getDemoMedications()
        medicineRepository.insertMedicine(medications)
    }


}