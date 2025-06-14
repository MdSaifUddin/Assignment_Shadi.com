package com.example.shadi.model

sealed class NetworkResponse<T>(val data: T?  = null, val errorMessage: String? = null) {
    class Loading<T>(): NetworkResponse<T>()
    class Success<T>(data: T? = null): NetworkResponse<T>(data = data)
    class Error<T>(errorMessage: String? = null): NetworkResponse<T>(errorMessage = errorMessage)
}