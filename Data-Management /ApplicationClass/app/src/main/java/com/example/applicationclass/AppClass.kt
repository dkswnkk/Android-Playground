package com.example.applicationclass

import android.app.Application
import android.util.Log

class AppClass :Application(){

    var value1 = 0
    var value2 = ""

    fun method1(){
        Log.d("test","method1을 호출 했습니다.")

    }

}