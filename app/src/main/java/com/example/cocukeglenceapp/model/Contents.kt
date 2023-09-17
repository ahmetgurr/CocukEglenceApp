package com.example.cocukeglenceapp.model
import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class Contents(var content_id:Int,
                    var content_name:String,
                    var content_con:String,
                    var content_image:String ){
}