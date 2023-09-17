package com.example.cocukeglenceapp.model

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable


@IgnoreExtraProperties
data class Categories(var category_id: Int, var category_name:String=""):Serializable {
}