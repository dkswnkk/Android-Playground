package com.example.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import com.example.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            //Popup Menu 객체[를 생성한다.
            val pop = PopupMenu(this,binding.textView)
            // 메뉴를 구성한다
            menuInflater.inflate(R.menu.menu1,pop.menu)
            pop.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.item1->{
                        binding.textView.text="1"
                    }
                    R. id.item2->{
                        binding.textView.text ="2"
                    }
                    R.id.item3->{
                        binding.textView.text="3"
                    }
                }
                true
            }
            pop.show()
        }
    }
}