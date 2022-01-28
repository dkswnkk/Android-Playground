package com.example.viewpager2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2.databinding.FragmentSub1Binding

class SubFragment1 : Fragment() {
    private lateinit var binding: FragmentSub1Binding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentSub1Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}