package com.example.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.snackbar.databinding.ActivityMainBinding
import com.example.snackbar.databinding.CustomSnackbarBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var snackbarBinding: CustomSnackbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        snackbarBinding = CustomSnackbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(snackbarBinding.root)


        binding.button1.setOnClickListener {
//            val snack1 = Snackbar.make(it,"기본 스낵바",Snackbar.LENGTH_SHORT)
            val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_INDEFINITE)  //누를때까지 기다린다.
            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.WHITE)
            snack1.animationMode = Snackbar.ANIMATION_MODE_SLIDE

            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    binding.textView2.text = "스낵바가 나타났습니다"
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    binding.textView2.text = "스낵바가 사라졌습니다."
                }

            }
            snack1.addCallback(callback)


            snack1.setAction("Action1") {
                binding.textView1.text = "Actionzz"
            }
            snack1.show()
        }

        binding.button2.setOnClickListener {
            // 스낵바를 만들어준다.
            val snack2 = Snackbar.make(it, "customSnackBar", Snackbar.LENGTH_SHORT)
            // 스낵바를 통해 보여줄 뷰를 생성한다.
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar, null)
            // 스낵바 레이아웃을 추출해서 새로운 뷰를 추가한다.
            val snackbarLayout = snack2.view as Snackbar.SnackbarLayout
            snackbarLayout.addView(snackView)

            snack2.run {
                snackbarBinding.imageView.setImageResource(R.drawable.imgflag8)
                snackbarBinding.snackbarTextView1.text = "zz"
                snackbarBinding.snackbarTextView1.setTextColor(Color.WHITE)
            }
//            스낵바에 있는 TextView를 추출해 이를 보이지 않게 처리한다.

            val snackText =
                snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE

            snack2.show()
        }

        binding.button3.setOnClickListener {
            val snackBar =
                Snackbar.make(it, "zz", Snackbar.LENGTH_INDEFINITE).setAction("여기 추가 버튼") {
                    Log.d("test1", "흐음")
                }
            snackBar.setTextColor(Color.WHITE)
            val snackBarView = snackBar.view

            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    Log.d("ZZ","?")
                 
                }
            }
            snackBar.addCallback(callback)
//            val txt = snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
//            txt.setTextColor(Color.WHITE)
            snackBar.show()
        }
    }
}
