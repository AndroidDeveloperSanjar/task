package uz.kattabozor.task.extensions

import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import org.json.JSONException
import retrofit2.HttpException
import uz.kattabozor.task.utils.ErrorEntity
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

fun Throwable.errorEntity(): ErrorEntity {
    return when (this) {
        is JsonSyntaxException -> ErrorEntity.ApiErrorEntity.JsonSyntaxException
        is JsonParseException -> ErrorEntity.ApiErrorEntity.JsonParseException
        is JSONException -> ErrorEntity.ApiErrorEntity.JSONException
        is KotlinNullPointerException -> ErrorEntity.ApiErrorEntity.KotlinNullPointerException
        is NullPointerException -> ErrorEntity.ApiErrorEntity.NullPointerException
        is HttpException -> ErrorEntity.ApiErrorEntity.HttpException(
            this.code(), message ?: localizedMessage
        )

        is com.google.gson.stream.MalformedJsonException -> ErrorEntity.ApiErrorEntity.MalformedJsonException
        is UnknownHostException -> ErrorEntity.ApiErrorEntity.UnknownHostException
        is SSLHandshakeException -> ErrorEntity.ApiErrorEntity.SSLHandshakeException
        is SSLException -> ErrorEntity.ApiErrorEntity.SSLException
        is SocketException -> ErrorEntity.ApiErrorEntity.SocketException
        is SocketTimeoutException -> ErrorEntity.ApiErrorEntity.SocketTimeoutException
        is IOException -> ErrorEntity.ApiErrorEntity.IOException
        else -> ErrorEntity.ApiErrorEntity.OtherApiException(
            cause?.localizedMessage ?: cause?.message ?: "Nothing"
        )
    }
}