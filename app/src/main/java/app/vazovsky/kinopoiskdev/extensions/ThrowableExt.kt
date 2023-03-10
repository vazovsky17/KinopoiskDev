package app.vazovsky.kinopoiskdev.extensions

import app.vazovsky.kinopoiskdev.data.model.base.ApiErrorResponse
import app.vazovsky.kinopoiskdev.data.model.base.DEFAULT_ERROR_CODE
import app.vazovsky.kinopoiskdev.data.model.base.DEFAULT_ERROR_MESSAGE
import app.vazovsky.kinopoiskdev.data.model.base.GeneralError
import app.vazovsky.kinopoiskdev.data.model.base.NetworkError
import app.vazovsky.kinopoiskdev.data.model.base.ParsedError
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import retrofit2.HttpException
import timber.log.Timber

val Throwable.isNetworkError: Boolean
    get() = when (this) {
        is ConnectException,
        is UnknownHostException,
        is SocketTimeoutException -> true

        else -> false
    }

fun Throwable.parseError(): ParsedError {
    Timber.e(this)
    val code = DEFAULT_ERROR_CODE
    val message = DEFAULT_ERROR_MESSAGE

    return when {
        isNetworkError -> NetworkError(code, message)
        this is HttpException -> {
            val body = response()?.errorBody()
            val gson = GsonBuilder().create()
            var error: ParsedError? = null
            try {
                val apiError = gson.fromJson(body?.string(), ApiErrorResponse::class.java)
                response()?.code()?.let { error = apiError?.toParsedError() }
            } catch (ioEx: IOException) {
                Timber.e(ioEx)
            } catch (isEx: IllegalStateException) {
                Timber.e(isEx)
            } catch (jsEx: JsonSyntaxException) {
                Timber.e(jsEx)
            }
            error ?: GeneralError(code, message)
        }

        else -> {
            GeneralError(code, message)
        }
    }
}