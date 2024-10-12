package com.medicare.data.repository

import com.medicare.database.model.Medicine
import kotlinx.coroutines.flow.Flow

interface MedicineRepository {

    suspend fun upsertMedicine(medicine: Medicine)

    suspend fun insertMedicine(medicines :List<Medicine>)

    suspend fun getMedicineById(id:Int) :Medicine?
}