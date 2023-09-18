package com.example.cocukeglenceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocukeglenceapp.R
import com.example.cocukeglenceapp.adapter.CategoryAdapter
import com.example.cocukeglenceapp.adapter.ListAdapter
import com.example.cocukeglenceapp.databinding.FragmentCategoryBinding
import com.example.cocukeglenceapp.databinding.FragmentListBinding
import com.example.cocukeglenceapp.model.Contents
import com.example.cocukeglenceapp.viewmodel.CategoryViewModel
import com.example.cocukeglenceapp.viewmodel.ListViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var listAdapter: ListAdapter
    private val viewModel: ListViewModel by viewModels()
    private val args: ListViewModel by navArgs()
    private lateinit var refList: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentListBinding.bind(view)//binding tanımlama->kullanmazsan app çöker
        //binding.toolbarCategory.title = "Kategori"

        //Activity'yi AppCompatActivity türüne dönüştürüyoruz ve setSupportActionBar kullanarak Toolbarı ayarlıyoruz
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbarList)

        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar//Toolbar'ı özelleştirme ve başlığı ayarlama
        actionBar?.apply {
            title = "Listeler"
            //setDisplayHomeAsUpEnabled(true)//Toolbar'a geri butonu ekliyoruz
        }
        val database = FirebaseDatabase.getInstance()
        refList = database.getReference("tekerlemeler")

        binding.listRV.layoutManager = LinearLayoutManager(requireContext())//recyclerview'ı ayarlama
    }


    private fun navigateToDetail(content: Contents) {
        val action = ListFragmentDirections.navigateToDetail(content)
        findNavController().navigate(action)
    }

    private fun observeLiveData() {
        viewModel.contentLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                listAdapter = ListAdapter(it, ::navigateToDetail)
                binding.listRV.adapter = listAdapter//recyclerview'a adapter'ı bağlama
            } else {
                Snackbar.make(requireView(), "List is empty!!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}