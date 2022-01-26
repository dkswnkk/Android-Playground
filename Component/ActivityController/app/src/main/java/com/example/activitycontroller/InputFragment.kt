package com.example.activitycontroller

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activitycontroller.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding

    override fun onAttach(context: Context) {
        binding = FragmentInputBinding.inflate(layoutInflater)
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
        binding.inputButton.setOnClickListener {
            Log.d("test", "4")
            val mainActivity = activity as MainActivity
            mainActivity.value1 = binding.inputEdit1.getText().toString()   //getText 무조건 해줘야함 ...
            mainActivity.value2 = binding.inputEdit2.getText().toString()
            mainActivity.setFragment("resultFragment")
        }

    }

}