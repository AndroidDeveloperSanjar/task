package uz.kattabozor.task.presentation.model.offer

data class UIOfferChildModel(
    val uiAttributeModels: List<UIAttributeModel>,
    val brand: String,
    val category: String,
    val id: Int,
    val uiImageModel: UIImageModel,
    val merchant: String,
    val name: String
)