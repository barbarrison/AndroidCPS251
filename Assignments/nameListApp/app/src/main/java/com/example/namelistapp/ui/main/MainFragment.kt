package com.example.namelistapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.namelistapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.displayNameList.text = viewModel.getNames()

        binding.addNameButton.setOnClickListener {

            if(!binding.inputPersonName.text.toString().trim().isEmpty()){
                viewModel.addName(binding.inputPersonName.text.toString())
                binding.displayNameList.text = viewModel.getNames()
                binding.inputPersonName.text.clear()

            }else{
                binding.inputPersonName.text.clear()
            }

        }

        binding.clearButton.setOnClickListener {
            binding.displayNameList.text = "No names to display"
            viewModel.clearNames()

        }

    }

}