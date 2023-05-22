package uz.kattabozor.task.data.repository

import kotlinx.coroutines.flow.flow
import uz.kattabozor.task.data.OfferApiService
import uz.kattabozor.task.data.mapper.DataMapper
import uz.kattabozor.task.domain.repository.OfferRepository

class OfferRepositoryImpl(
    private val apiService: OfferApiService, private val mapper: DataMapper
) : OfferRepository {
    override fun getOffers() = flow {
        if (apiService.getOffers().isSuccessful) emit(
            apiService.getOffers().body()?.let(mapper::mapFromDataOfferModelToDomainOfferModel)
        )
    }
}