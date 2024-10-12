package com.medicare.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.medicare.database.model.Medicine
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicineDao {

    @Upsert
    suspend fun upsertMedicine( medicine: Medicine)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicines(medicines: List<Medicine>)

    @Delete
    suspend fun deleteMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicine WHERE id = :id")
    suspend fun getMedicineById(id:Int) : Medicine?


    @Query("SELECT * FROM medicine")
    fun getMedicine() :Flow<List<Medicine>>


}