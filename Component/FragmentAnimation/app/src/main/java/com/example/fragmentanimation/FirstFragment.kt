package com.example.fragmentanimation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentanimation.databinding.FragmentFirstBinding

class FirstFragment:Fragment() {
    private lateinit var binding:FragmentFirstBinding

    override fun onAttach(context: Context) {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstButton1.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.setFragment("second")
        }
    }

}