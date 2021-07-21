package com.akp.my_students_app.models

import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("Class")
    var `class`: String,
    var name: String,
    var seat: String
)