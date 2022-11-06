package com.example.transcendenttortoise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.transcendenttortoise.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.moveToFirst)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStart(){
        super.onStart()
        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            binding.imageTitle.text = args.imageTitle
            val testFile = args.imageID
            if(testFile.equals("android_image_1")){
                binding.imageView2.setImageResource(R.drawable.android_image_1)
                return
            }
            if(testFile.equals("android_image_2")){
                binding.imageView2.setImageResource(R.drawable.android_image_2)
                return
            }
            if(testFile.equals("android_image_3")){
                binding.imageView2.setImageResource(R.drawable.android_image_3)
                return
            }
        }
    }

}