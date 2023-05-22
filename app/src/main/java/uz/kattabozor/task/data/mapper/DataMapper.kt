package uz.kattabozor.task.data.mapper

import uz.kattabozor.task.data.model.offer.DataAttributeModel
import uz.kattabozor.task.data.model.offer.DataOfferChildModel
import uz.kattabozor.task.data.model.offer.DataOfferModel
import uz.kattabozor.task.domain.model.offer.DomainAttributeModel
import uz.kattabozor.task.domain.model.offer.DomainImageModel
import uz.kattabozor.task.domain.model.offer.DomainOfferChildModel
import uz.kattabozor.task.domain.model.offer.DomainOfferModel

interface DataMapper {
    fun mapFromDataAttributeModelsToDomainAttributeModels(dataModel: DataAttributeModel): DomainAttributeModel
    fun mapFromDataOfferChildModelToDomainOfferChildModel(dataModel: DataOfferChildModel): DomainOfferChildModel
    fun mapFromDataOfferModelToDomainOfferModel(dataModel: DataOfferModel): DomainOfferModel
}

class DataMapperImpl : DataMapper {
    override fun mapFromDataAttributeModelsToDomainAttributeModels(dataModel: DataAttributeModel) =
        with(dataModel) {
            DomainAttributeModel(
                name = name, value = value
            )
        }

    override fun mapFromDataOfferChildModelToDomainOfferChildModel(dataModel: DataOfferChildModel) =
        with(dataModel) {
            DomainOfferChildModel(
                domainAttributeModels = attributes.map {
                    mapFromDataAttributeModelsToDomainAttributeModels(it)
                },
                brand = brand,
                category = category,
                id = id,
                domainImageModel = with(image) {
                    DomainImageModel(height = height, url = url, width = width)
                },
                merchant = merchant,
                name = name
            )
        }

    override fun mapFromDataOfferModelToDomainOfferModel(dataModel: DataOfferModel) =
        with(dataModel) {
            DomainOfferModel(offers.map {
                mapFromDataOfferChildModelToDomainOfferChildModel(it)
            })
        }
}