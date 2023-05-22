package uz.kattabozor.task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.kattabozor.task.data.OfferApiService
import uz.kattabozor.task.data.mapper.DataMapper
import uz.kattabozor.task.data.repository.OfferRepositoryImpl
import uz.kattabozor.task.domain.repository.OfferRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideOfferRepository(
        apiService: OfferApiService,
        mapper: DataMapper
    ) : OfferRepository = OfferRepositoryImpl(apiService, mapper)

}