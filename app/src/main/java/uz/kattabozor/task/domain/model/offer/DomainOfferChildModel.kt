package uz.kattabozor.task.domain.model.offer

data class DomainOfferChildModel(
    val domainAttributeModels: List<DomainAttributeModel>,
    val brand: String,
    val category: String,
    val id: Int,
    val domainImageModel: DomainImageModel,
    val merchant: String,
    val name: String
)