package uz.kattabozor.task.domain.mapper

import uz.kattabozor.task.domain.model.offer.DomainAttributeModel
import uz.kattabozor.task.domain.model.offer.DomainOfferChildModel
import uz.kattabozor.task.domain.model.offer.DomainOfferModel
import uz.kattabozor.task.presentation.model.offer.UIAttributeModel
import uz.kattabozor.task.presentation.model.offer.UIImageModel
import uz.kattabozor.task.presentation.model.offer.UIOfferChildModel
import uz.kattabozor.task.presentation.model.offer.UIOfferModel

interface DomainMapper {
    fun mapFromDomainAttributeModelsToUIAttributeModels(domainModel: DomainAttributeModel): UIAttributeModel
    fun mapFromDomainOfferChildModelToUIOfferChildModel(domainModel: DomainOfferChildModel): UIOfferChildModel
    fun mapFromDomainOfferModelToUIOfferModel(domainModel: DomainOfferModel): UIOfferModel
}

class DomainMapperImpl : DomainMapper {
    override fun mapFromDomainAttributeModelsToUIAttributeModels(domainModel: DomainAttributeModel) =
        with(domainModel) {
            UIAttributeModel(
                name = name, value = value
            )
        }

    override fun mapFromDomainOfferChildModelToUIOfferChildModel(domainModel: DomainOfferChildModel) =
        with(domainModel) {
            UIOfferChildModel(
                uiAttributeModels = domainAttributeModels.map {
                    mapFromDomainAttributeModelsToUIAttributeModels(it)
                },
                brand = brand,
                category = category,
                id = id,
                uiImageModel = with(domainImageModel) {
                    UIImageModel(height = height, url = url, width = width)
                },
                merchant = merchant,
                name = name
            )
        }

    override fun mapFromDomainOfferModelToUIOfferModel(domainModel: DomainOfferModel) =
        with(domainModel) {
            UIOfferModel(domainOfferChildModels.map {
                mapFromDomainOfferChildModelToUIOfferChildModel(it)
            })
        }
}