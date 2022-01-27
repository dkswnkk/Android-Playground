package com.example.fragmentanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment("first")
    }

    fun setFragment(name: String) {
        val tran = supportFragmentManager.beginTransaction()
        when (name) {
            "first" -> {
//                tran.replace(R.id.container1, firstFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
//                tran.replace(R.id.container1, firstFragment).setCustomAnimations(
//                    R.anim.fade_xml1,
//                    R.anim.fade_xml2,
//                    R.anim.fade_xml1,
//                    R.anim.fade_xml2,
//                ).commit()
                tran.replace(R.id.container1, firstFragment).setCustomAnimations(
                    R.anim.slide_xml1,
                    R.anim.slide_xml2,
                    R.anim.slide_xml3,
                    R.anim.slide_xml4,
                ).commit()
            }
            "second" -> {
                tran.replace(R.id.container1, secondFragment).addToBackStack(null).commit()

            }
        }
    }
}