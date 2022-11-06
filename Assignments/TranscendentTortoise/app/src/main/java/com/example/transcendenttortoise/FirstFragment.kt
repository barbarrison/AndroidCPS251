package com.example.transcendenttortoise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.transcendenttortoise.databinding.FragmentFirstBinding
import com.example.transcendenttortoise.ui.main.MainViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.imgButton1.setOnClickListener {
            val action1 : FirstFragmentDirections.MoveToSecond =
                FirstFragmentDirections.moveToSecond()
            action1.imageID = "android_image_1"
            action1.imageTitle = "Image One"
            Navigation.findNavController(it).navigate(action1)
        }
        binding.imgButton2.setOnClickListener {
            val action1 : FirstFragmentDirections.MoveToSecond =
                FirstFragmentDirections.moveToSecond()
            action1.imageID = "android_image_2"
            action1.imageTitle = "Image Two"
            Navigation.findNavController(it).navigate(action1)
        }
        binding.imgButton3.setOnClickListener {
            val action1 : FirstFragmentDirections.MoveToSecond =
                FirstFragmentDirections.moveToSecond()
            action1.imageID = "android_image_3"
            action1.imageTitle = "Image Three"
            Navigation.findNavController(it).navigate(action1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}