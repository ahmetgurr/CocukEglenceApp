package com.example.cocukeglenceapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocukeglenceapp.model.Categories
import com.example.cocukeglenceapp.model.Contents
import com.example.cocukeglenceapp.repository.DataRepository
import com.google.firebase.database.DatabaseReference

class ListViewModel : ViewModel() {


    val homeRepository = DataRepository()
    var contentLiveData = MutableLiveData<List<Contents>>()

    fun uploadContent() =
        homeRepository.getContentLiveData()
}
