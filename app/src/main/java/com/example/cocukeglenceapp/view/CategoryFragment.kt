package com.example.cocukeglenceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocukeglenceapp.R
import com.example.cocukeglenceapp.adapter.CategoryAdapter
import com.example.cocukeglenceapp.databinding.FragmentCategoryBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private lateinit var refCategory: DatabaseReference
    private lateinit var categoryadapter: CategoryAdapter
    private lateinit var toolbar: Toolbar

    //private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)//binding tanımlama->kullanmazsan app çöker
        //binding.toolbarCategory.title = "Kategori"

        //Activity'yi AppCompatActivity türüne dönüştürüyoruz ve setSupportActionBar kullanarak Toolbarı ayarlıyoruz
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarCategory)

        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar//Toolbar'ı özelleştirme ve başlığı ayarlama
        actionBar?.apply {
            title = "Kategoriler"
            //setDisplayHomeAsUpEnabled(true)//Toolbar'a geri butonu ekliyoruz

            val database = FirebaseDatabase.getInstance()
            refCategory = database.getReference("bilmeceler")

            binding.categoryRV.layoutManager = LinearLayoutManager(requireContext())//recyclerview'ı ayarlama

           // categoryadapter = CategoryAdapter() // tamamlanacak


        }
    }

}