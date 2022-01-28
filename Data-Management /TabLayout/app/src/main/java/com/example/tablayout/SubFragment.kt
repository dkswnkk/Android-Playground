package com.example.tablayout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tablayout.databinding.FragmentSubBinding

class SubFragment : Fragment {
    lateinit var title: String
    lateinit var binding:FragmentSubBinding

    constructor(title: String) {
        this.title = title
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentSubBinding.inflate(layoutInflater)
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
        binding.textView.text = title
    }
}