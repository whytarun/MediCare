package com.medicare.data.repository

import com.medicare.database.db.AppDatabase
import com.medicare.database.model.Medicine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicineRepositoryImpl @Inject constructor(
    private val  appDatabase: AppDatabase
) : MedicineRepository{

    private val medicineDao =appDatabase.medicineDao()
    override suspend fun upsertMedicine(medicine: Medicine) {
        medicineDao.upsertMedicine(medicine)
    }

    override suspend fun insertMedicine(medicines: List<Medicine>) {
        medicineDao.insertMedicines(medicines)
    }

    override suspend fun getMedicineById(id: Int): Medicine? {
       return medicineDao.getMedicineById(id)
    }
}