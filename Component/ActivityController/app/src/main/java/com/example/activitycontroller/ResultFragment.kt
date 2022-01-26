package com.example.activitycontroller

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activitycontroller.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    override fun onAttach(context: Context) {
        binding = FragmentResultBinding.inflate(layoutInflater)
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
        val mainActivity = activity as MainActivity
        binding.resultText1.text = mainActivity.value1
        binding.resultText2.text = mainActivity.value2
    }
}