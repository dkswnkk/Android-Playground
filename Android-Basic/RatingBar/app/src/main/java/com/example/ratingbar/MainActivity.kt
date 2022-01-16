package com.example.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            textView1.text = "Rating 1: ${ratingBar1.rating}\n"
            textView1.append("Rating2: ${ratingBar2.rating}\n")
            textView1.append("Rating3: ${ratingBar3.rating}\n")
            textView1.append("Rating4: ${ratingBar4.rating}\n")
        }
        button2.setOnClickListener {
            ratingBar1.rating = 1.0f
            ratingBar2.rating=0.5f
            ratingBar3.rating=1.0f
            ratingBar4.rating = 1.5f
        }
        ratingBar2.setOnRatingBarChangeListener(listner1)
        ratingBar3.setOnRatingBarChangeListener(listner1)
    }

    var listner1 = object: RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
            when(p0?.id){
                R.id.ratingBar2->{
                    textView1.text = "Rating2 ${p1}\n"
                    if(p2){
                        textView1.append("사용자가 설정했습니다.")
                    }
                    else{
                        textView1.append("코드를 통해 설정했습니다.")
                    }
                }
                R.id.ratingBar3->{
                    textView2.text = "Rating3 ${p1}\n"
                    if(p2){
                        textView2.append("사용자가 설정했습니다.")
                    }
                    else{
                        textView2.append("코드를 통해 설정했습니다.")
                    }
                }
            }
        }
    }
}