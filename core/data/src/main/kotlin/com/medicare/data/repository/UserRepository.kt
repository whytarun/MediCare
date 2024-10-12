package com.medicare.data.repository

import com.medicare.database.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun upsertUser(user: User)

    suspend fun getUser(): User?
}