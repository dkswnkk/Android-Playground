package com.example.toolbaractionview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import com.example.toolbaractionview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataList = arrayOf("aaaa", "bbbb", "cccc", "dddd", "aabb", "bbcc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        binding.list1.adapter = adapter
        binding.list1.isTextFilterEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val item1 = menu?.findItem(R.id.item1)
        val search1 = item1?.actionView as SearchView
        search1.queryHint = "힌"

        // 액션뷰가 접혀지거나 펼쳐졌을 떄 반응할 리스너
        val listner1 = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                Log.d("test", "접혀짐")
                return true
            }

            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                Log.d("test", "펼쳐")
                return true
            }
        }
        item1.setOnActionExpandListener(listner1)
        val listner2 = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("test", "${newText}")
                binding.list1.setFilterText(newText)
                if(newText==""){
                    binding.list1.clearTextFilter()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("test", "${query}")
                search1.clearFocus()
                return true
            }
        }
        search1.setOnQueryTextListener(listner2)
        return true
    }
}