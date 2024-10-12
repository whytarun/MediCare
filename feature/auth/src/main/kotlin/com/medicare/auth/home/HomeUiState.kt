package com.medicare.auth.home

import com.medicare.database.model.Medicine

data class HomeUiState(
     val greeting:String= "",
     val medicine: List<Medicine> = emptyList()
)
