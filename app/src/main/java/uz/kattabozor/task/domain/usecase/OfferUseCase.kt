package uz.kattabozor.task.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.kattabozor.task.presentation.model.offer.UIOfferModel

interface OfferUseCase {
    operator fun invoke(): Flow<UIOfferModel?>
}