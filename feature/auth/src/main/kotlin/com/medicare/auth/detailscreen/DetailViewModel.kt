package com.medicare.auth.detailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medicare.data.repository.MedicineRepository
import com.medicare.database.model.Medicine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val medicineRepository: MedicineRepository
) :ViewModel(){

    private val _medicine = MutableStateFlow<Medicine?>(null)
    val medicine =_medicine.asStateFlow()

    fun loadMedicine( medicineId :Int){
        viewModelScope.launch {
            val result = medicineRepository.getMedicineById(medicineId)
            _medicine.value = result
        }
    }
}