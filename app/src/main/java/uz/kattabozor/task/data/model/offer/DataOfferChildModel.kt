package uz.kattabozor.task.data.model.offer

import androidx.annotation.Keep

@Keep
data class DataOfferChildModel(
    val attributes: List<DataAttributeModel>,
    val brand: String,
    val category: String,
    val id: Int,
    val image: DataImageModel,
    val merchant: String,
    val name: String
)