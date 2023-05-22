package uz.kattabozor.task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.kattabozor.task.data.mapper.DataMapper
import uz.kattabozor.task.data.mapper.DataMapperImpl
import uz.kattabozor.task.domain.mapper.DomainMapper
import uz.kattabozor.task.domain.mapper.DomainMapperImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideDataMapper(): DataMapper = DataMapperImpl()

    @Provides
    @Singleton
    fun provideDomainMapper(): DomainMapper = DomainMapperImpl()
}