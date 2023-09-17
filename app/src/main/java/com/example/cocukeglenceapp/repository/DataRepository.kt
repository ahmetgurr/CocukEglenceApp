package com.example.cocukeglenceapp.repository

import com.google.firebase.database.DatabaseReference
import androidx.lifecycle.MutableLiveData
import com.example.cocukeglenceapp.model.Categories
import com.example.cocukeglenceapp.model.Contents
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
class DataRepository {
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun getLiveDataFromFirebase(): MutableLiveData<List<Categories>> {
        val liveData = MutableLiveData<List<Categories>>()

        databaseReference.child("categories").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val dataList = mutableListOf<Categories>()

                for (childSnapshot in snapshot.children) {
                    val yourData = childSnapshot.getValue(Categories::class.java)
                    yourData?.let {
                        dataList.add(it)
                    }
                }

                liveData.postValue(dataList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error if needed
            }
        })

        return liveData
    }



    fun getContentLiveData(): MutableLiveData<List<Contents>> {
        val contentLiveData = MutableLiveData<List<Contents>>()

        databaseReference.child("contents").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val contentList = mutableListOf<Contents>()

                for (dataSnapshot in snapshot.children) {
                    val content = dataSnapshot.getValue(Contents::class.java)
                    content?.let {
                        contentList.add(it)
                    }
                }

                contentLiveData.postValue(contentList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error if needed
            }
        })

        return contentLiveData
    }
}