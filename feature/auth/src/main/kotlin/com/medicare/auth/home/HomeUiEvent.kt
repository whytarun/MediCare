package com.medicare.auth.home

import com.medicare.database.model.Medicine

sealed class HomeUiEvent {

    data object OnLoadData : HomeUiEvent()
    data class OnMedicineClick(val medicine: Medicine) :HomeUiEvent()
}