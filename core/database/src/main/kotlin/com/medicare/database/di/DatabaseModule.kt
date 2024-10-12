package com.medicare.database.di

import android.app.Application
import androidx.room.Room
import com.medicare.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMedicineDatabase(application: Application) :AppDatabase{
            return Room.databaseBuilder(
                application,
                AppDatabase::class.java,
                AppDatabase.NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}