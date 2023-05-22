package uz.kattabozor.task.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.kattabozor.task.domain.mapper.DomainMapper
import uz.kattabozor.task.domain.repository.OfferRepository
import uz.kattabozor.task.domain.usecase.OfferUseCase
import uz.kattabozor.task.domain.usecase.OfferUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    @ViewModelScoped
    fun provideOfferUseCase(repository: OfferRepository, mapper: DomainMapper): OfferUseCase =
        OfferUseCaseImpl(repository, mapper)

}