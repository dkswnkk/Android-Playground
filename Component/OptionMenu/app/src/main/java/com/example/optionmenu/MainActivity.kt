package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // XML로 메뉴를 구성한다.
//        menuInflater.inflate(R.menu.main_menu,menu)

        menu?.add(Menu.NONE,Menu.FIRST,Menu.NONE,)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 메뉴의 id 별로 분기한다.
        when(item.itemId){
//            R.id.item1->{
//                binding.textView.text ="메뉴 1을 눌렀습니다."
//            }
            R.id.Item1_1->{
            }
            R.id.Item1_2->{
            }
            R.id.item2->{
                binding.textView.text ="메뉴 2를 눌렀습니다."
            }
            R.id.item3->{
                binding.textView.text ="메뉴 3을 눌렀습니다."
            }
        }
        return super.onOptionsItemSelected(item)
    }

}