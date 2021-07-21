package com.akp.my_students_app.api

import com.akp.my_students_app.models.Items
import com.akp.my_students_app.models.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PlaceHolderApi {

    @GET("items")
    suspend fun getItems(): List<Items>

    @POST( "students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>


}