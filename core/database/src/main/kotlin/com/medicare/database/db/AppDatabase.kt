package com.medicare.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.medicare.database.dao.MedicineDao
import com.medicare.database.dao.UserDao
import com.medicare.database.model.Medicine
import com.medicare.database.model.User

@Database(entities = [Medicine::class, User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun medicineDao() :MedicineDao
    abstract  fun userDao() :UserDao
    companion object{
        const val NAME ="medicine_db"
    }
}
