package com.example.machinetest.di

import android.content.Context
import androidx.room.Room
import com.example.machinetest.data.repository.ProductRepository
import com.example.machinetest.data.repository.ProductRepositoryImpl
import com.example.machinetest.db.MyAppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): MyAppDataBase {
        return Room.databaseBuilder(context,MyAppDataBase::class.java,"MyApp DataBase").fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideProductRepository(db : MyAppDataBase) : ProductRepository = ProductRepositoryImpl(db = db)
}