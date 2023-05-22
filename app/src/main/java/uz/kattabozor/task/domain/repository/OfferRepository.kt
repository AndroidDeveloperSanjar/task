package uz.kattabozor.task.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.kattabozor.task.domain.model.offer.DomainOfferModel

interface OfferRepository {
    fun getOffers(): Flow<DomainOfferModel?>
}