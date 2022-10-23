package com.example.namelistappredux.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.namelistappredux.R
import com.example.namelistappredux.databinding.FragmentMainBinding

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

        val nameListObserver = Observer<String>{
            outputNames -> binding.displayNameList.text = outputNames.toString()
        }
        viewModel.getNames().observe(viewLifecycleOwner,nameListObserver)

        binding.addNameButton.setOnClickListener {
            if(!binding.inputPersonName.text.toString().trim().isEmpty()){
                viewModel.addName(binding.inputPersonName.text.toString())
                binding.inputPersonName.text.clear()
            }else{
                binding.inputPersonName.text.clear()
            }

        }

        binding.clearButton.setOnClickListener {
            binding.displayNameList.text = getString(R.string.emptyList)
            viewModel.clearNames()

        }

    }

}