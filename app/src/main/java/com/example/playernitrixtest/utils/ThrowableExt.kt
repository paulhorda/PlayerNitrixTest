package com.example.playernitrixtest.utils

import kotlinx.coroutines.TimeoutCancellationException
import java.io.IOException

fun Throwable.getErrorMessage(): String {
    return when (this) {
        is IOException -> "Network error, please check your connection."
        is TimeoutCancellationException -> "Request timed out, please try again."
        else -> "An unexpected error occurred."
    }
}