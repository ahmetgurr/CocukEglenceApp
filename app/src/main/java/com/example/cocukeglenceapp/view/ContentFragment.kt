package com.example.cocukeglenceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.cocukeglenceapp.R
import com.example.cocukeglenceapp.databinding.FragmentContentBinding

class ContentFragment : Fragment(R.layout.fragment_content) {

    private lateinit var binding: FragmentContentBinding
    private val args: ContentFragmentArg by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding = FragmentContentBinding.bind(view)

            val data = args.contentDetail

            binding.toolbarContent.title = "${data.contentName}"
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbarContent)
        }

    }
}