package com.top.best.ecommerce.bd.auction.bazar.core

sealed class DataState<T>(val message: String? = null,val data: T? = null) {

    class Loading<T>: DataState<T>()

    class Success<T>(data: T?): DataState<T>(null,data)

    class Error<T>(message: String?): DataState<T>(message,null)

}
