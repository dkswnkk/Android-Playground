package com.example.preferencesscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.preferencesscreen.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentResultBinding.inflate(layoutInflater)
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

        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val data1 = pref.getString("data1",null)
        binding.textView2.text = data1

        val data2 = pref.getBoolean("data2",false)
        binding.textView2.append("\n${data2}")

        val data3 = pref.getBoolean("data3",false)
        binding.textView2.append("\n${data3}")

        val data4 = pref.getString("data4",null)
        binding.textView2.append("\n${data4}")

        val data5 = pref.getStringSet("data5",null)
        for(i in data5!!){
            binding.textView2.append("\n${i}")
        }

    }
}