package com.example.actionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import com.example.actionview.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val data1 = arrayOf("aaaa", "bbbb", "cccc", "aabb", "ccdd")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list1.adapter = adapter

        // 검색어 기준으로 필터링 될 수 있도록 설정한다.
        binding.list1.isTextFilterEnabled = true

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // SearchView를 가지고 있는 메뉴 아이템 객체를 추출
        val item1 = menu?.findItem(R.id.item1)
        // SearchView 객체를 가지고 온다.
        val search1 = item1?.actionView as SearchView
        // 안내 문구를 설정한다.
        search1.queryHint = "검색어 입력"
        // 메뉴 아이템에 배치된 뷰가 접히거나 펼쳐질 때 반응하는 리스너
        val listner1 = object : MenuItem.OnActionExpandListener {
            // 접혔을 때
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                binding.textView.text = "접혀졌습니다."
                return true
            }

            // 펼쳐졌을 때
            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                binding.textView.text = "펼쳐졌습니다."
                return true
            }
        }
        item1.setOnActionExpandListener(listner1)

        // SearchView 리스너
        val listner2 = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                binding.textView2.text = newText

                // SearchView에 입력한 내용을 ListView의 필터 문자열로 설정한다.
                binding.list1.setFilterText(newText)

                // 만약 설정한 문자열의 길이가 0 이라면 필터 문자열을 제거한다.
                if(newText?.length==0){
                    binding.list1.clearTextFilter()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.textView.text = query
                search1.clearFocus()
                return true
            }
        }
        search1.setOnQueryTextListener(listner2)
        return true
    }
}