package com.example.textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1.text = "zz"
        text1.append("hmm~")
        text1.setTextColor(Color.BLUE)
        text1.setBackgroundColor(Color.GRAY)


    }
}