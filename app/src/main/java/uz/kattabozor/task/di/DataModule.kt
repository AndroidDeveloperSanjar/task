package uz.kattabozor.task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.kattabozor.task.data.OfferApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideOfferApiService(
        retrofit: Retrofit
    ) = retrofit.create(OfferApiService::class.java)

}