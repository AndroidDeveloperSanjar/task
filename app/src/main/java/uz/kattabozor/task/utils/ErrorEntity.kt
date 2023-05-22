package uz.kattabozor.task.utils

sealed class ErrorEntity {
    sealed class ApiErrorEntity : ErrorEntity() {
        object JsonParseException : ApiErrorEntity()
        object NullPointerException : ApiErrorEntity()
        object JsonSyntaxException : ApiErrorEntity()
        object JSONException : ApiErrorEntity()
        data class HttpException(
            val code: Int? = null,
            val errorMessage: String? = null,
        ) : ApiErrorEntity()

        object MalformedJsonException : ApiErrorEntity()
        object UnknownHostException : ApiErrorEntity()
        object IOException : ApiErrorEntity()
        object SSLHandshakeException : ApiErrorEntity()
        object SSLException : ApiErrorEntity()
        object SocketException : ApiErrorEntity()
        object SocketTimeoutException : ApiErrorEntity()
        object KotlinNullPointerException : ApiErrorEntity()
        data class OtherApiException(
            val errorMessage: String? = null
        ) : ApiErrorEntity()
    }

    sealed class ApiCodeErrorEntity : ErrorEntity() {
        object Error401 : ApiCodeErrorEntity()
        object Error407 : ApiCodeErrorEntity()
        object Error409 : ApiCodeErrorEntity()
        data class Error423(val errorBody: String? = null) : ApiCodeErrorEntity()
        data class Error426(val errorBody: String? = null) : ApiCodeErrorEntity()
        data class Error503(val errorBody: String? = null) : ApiCodeErrorEntity()
        data class Error504M418(val errorBody: String? = null) : ApiCodeErrorEntity()
        data class ErrorOtherCode(val errorBody: String? = null) : ApiCodeErrorEntity()
    }
}