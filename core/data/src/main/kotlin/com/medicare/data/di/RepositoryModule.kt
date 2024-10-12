package com.medicare.data.di

import com.medicare.data.repository.MedicineRepository
import com.medicare.data.repository.MedicineRepositoryImpl
import com.medicare.data.repository.UserRepository
import com.medicare.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindMedicineRepository(impl: MedicineRepositoryImpl): MedicineRepository
}