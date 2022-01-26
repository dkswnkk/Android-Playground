package com.example.listfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.listfragment.databinding.FragmentSubBinding

class SubFragment() : ListFragment() {
    private lateinit var binding :FragmentSubBinding
    private val data1 = arrayOf("항목1","항목2","항목3","항목4","항목5","항목6")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding = FragmentSubBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1,data1)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // 항목을 터치하면 호출되는 메서드
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        binding.subText1.text = data1[position]
    }

}