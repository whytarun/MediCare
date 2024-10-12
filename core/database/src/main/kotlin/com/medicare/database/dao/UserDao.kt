package com.medicare.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.medicare.database.model.Medicine
import com.medicare.database.model.User
import kotlinx.coroutines.flow.Flow

@Dao
 interface UserDao {
    @Upsert
    suspend fun upsertUser( user: User)

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getUser(): User?
}