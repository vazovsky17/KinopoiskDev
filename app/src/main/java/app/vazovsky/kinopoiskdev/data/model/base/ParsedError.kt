package app.vazovsky.kinopoiskdev.data.model.base

import app.vazovsky.kinopoiskdev.extensions.isNetworkError
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.google.gson.annotations.SerializedName
import java.io.IOException
import retrofit2.HttpException
import timber.log.Timber

sealed class ParsedError(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String
)

class NetworkError(code: String, message: String) : ParsedError(code, message)
class GeneralError(code: String, message: String) : ParsedError(code, message)
class ApiError(code: String, message: String) : ParsedError(code, message)

var DEFAULT_ERROR_MESSAGE: String = "KinopoiskDev"
const val DEFAULT_ERROR_CODE = "TEXT_ERROR"

