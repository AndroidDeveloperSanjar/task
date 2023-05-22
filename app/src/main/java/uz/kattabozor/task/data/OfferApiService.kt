package uz.kattabozor.task.data

import retrofit2.Response
import retrofit2.http.GET
import uz.kattabozor.task.data.model.offer.DataOfferModel

interface OfferApiService {

    @GET("offers")
    suspend fun getOffers(): Response<DataOfferModel>

}