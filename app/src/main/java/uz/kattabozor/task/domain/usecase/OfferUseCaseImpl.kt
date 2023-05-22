package uz.kattabozor.task.domain.usecase

import kotlinx.coroutines.flow.map
import uz.kattabozor.task.domain.mapper.DomainMapper
import uz.kattabozor.task.domain.repository.OfferRepository

class OfferUseCaseImpl(
    private val repository: OfferRepository, private val domainMapper: DomainMapper
) : OfferUseCase {
    override fun invoke() = repository.getOffers().map {
        it?.let(domainMapper::mapFromDomainOfferModelToUIOfferModel)
    }
}