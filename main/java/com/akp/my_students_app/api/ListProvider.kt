package com.akp.my_students_app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ListProvider {

    private val retrofit = Retrofit.Builder().baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val placeHolderApi = retrofit.create(PlaceHolderApi::class.java)
}