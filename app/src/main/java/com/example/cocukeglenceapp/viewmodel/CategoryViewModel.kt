package com.example.cocukeglenceapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cocukeglenceapp.model.Categories
import com.example.cocukeglenceapp.repository.DataRepository

class CategoryViewModel : ViewModel() {//ViewModel classı ile verileri tutuyoruz ve bu verileri fragmentlara gönderiyoruz

    val dataRepository = DataRepository()
    var categoriesListLiveData = MutableLiveData<List<Categories>>()//verileri tutmak için


    fun uploadCategories(){
        dataRepository.getLiveDataFromFirebase()//verileri çekmek için
    }

}