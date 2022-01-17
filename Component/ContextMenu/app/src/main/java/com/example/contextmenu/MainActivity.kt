package com.example.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val data1 = arrayOf(
        "항목1","항목2","항목3","항목4","항목5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.listView1.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,data1)

        binding.listView1.setOnItemClickListener { adapterView, view, i, l ->
            binding.textView.text="리스트뷰의 항목 클릭: ${data1[i]}"
        }

        // ContextMenu를 View에 등록한다.
        registerForContextMenu(binding.textView)
        registerForContextMenu(binding.listView1)

    }

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        // 길게 누른 View의 Id로 분기한다
        when(v?.id){
            R.id.textView->{
                menu?.setHeaderTitle("텍스트 뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1,menu)
            }
            R.id.listView1->{
                //사용자가 길게 누른 항목 인덱스를 파악하기 위해..
                val info = menuInfo as AdapterView.AdapterContextMenuInfo
                menu?.setHeaderTitle("리스트 뷰의 메뉴${info.position}")
                menuInflater.inflate(R.menu.menu2,menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //리스트 항목의 인덱스 번호를 받을 변수
        var position = 0
        when(item.itemId){
            R.id.listItem1,R.id.listItem2->{
                //Menu Info 객체를 추출한다.
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                position = info.position
            }
        }
        //메뉴의 id값으로 분기한다.
        when(item.itemId){
            R.id.textViewMenu1->{
                binding.textView.text="텍스트 뷰의 메뉴 1을 눌렀습니다."
            }
            R.id.textViewMenu2->{
                binding.textView.text="텍스트 뷰의 메뉴 2를 눌렸습니다."
            }
            R.id.listItem1->{
                binding.textView.text="리스트 뷰의 메뉴 1을 눌렸습니다.${position}"
            }
            R.id.listItem2->{
                binding.textView.text="리스트 뷰의 메뉴 2를 눌렸습니다.${position}"
            }
        }

        return super.onContextItemSelected(item)
    }
}