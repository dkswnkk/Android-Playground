package com.example.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            textView1.text = "SeekBar 1: ${seekBar1.progress}"
            textView2.text = "SeekBar 2: ${seekBar2.progress}"
        }
        button2.setOnClickListener {
            seekBar1.progress=3
            seekBar2.progress=5
        }

        button3.setOnClickListener {
            seekBar1.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        button4.setOnClickListener {
            seekBar1.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }
        seekBar1.setOnSeekBarChangeListener(listner1)
    }
    val listner1 = object:SeekBar.OnSeekBarChangeListener{
        //ProgressBa의 값이 변경되었을때
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            when(p0?.id){
                R.id.seekBar1->{
                    textView1.text = "첫 번쨰 seekBar가: ${p1}로 설정되었습니다.\n"
                }
                R.id.seekBar2->{
                    textView1.text = "두 번째 seekBar가 ${p1}로 설정되었습니다\n"
                }
            }
            if(p2){
                textView2.append(" 사용자에 의해 설정되었습니다.")
            }
            else{
                textView2.append("코드에 의해 설정되었습니다.")
            }
        }
        //사용자가 터치 했을 때
        override fun onStartTrackingTouch(p0: SeekBar?) {
           when(p0?.id){
               R.id.seekBar1->{
                   textView2.text ="첫 번째 SeekBar 사용자 터치 시작"
               }
               R.id.seekBar2->{
                   textView2.text = "두 번째 SeekBar 사용자 터치 시작"
               }
           }
        }
        //상요자가 터치를 끝냈을 때
        override fun onStopTrackingTouch(p0: SeekBar?) {
            when(p0?.id){
                R.id.seekBar1->{
                    textView2.text = "첫 번째 SeekBar 사용자 터치 종료"
                }
                R.id.seekBar2->{
                    textView2.text = "두 번째 SeekBar 사용자 터치 종료"
                }
            }
        }
    }

}