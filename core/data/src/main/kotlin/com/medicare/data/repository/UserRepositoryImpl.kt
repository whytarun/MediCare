package com.medicare.data.repository

import com.medicare.database.db.AppDatabase
import com.medicare.database.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val database: AppDatabase
) : UserRepository{

    private val  userDao = database.userDao()
    override suspend fun upsertUser(user: User) {
        userDao.upsertUser(user)
    }

    override suspend fun getUser(): User? {
        return userDao.getUser()
    }

}