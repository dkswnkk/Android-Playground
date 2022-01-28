package com.example.viewpager2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2.databinding.FragmentSub3Binding

class SubFragment3 : Fragment() {
    private lateinit var binding: FragmentSub3Binding
    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentSub3Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}