package com.example.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class SubFragment : Fragment() {

    // Fragment가 Activity와 연결될 때 호출된다.
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("test", "onAttatch")
    }

    // Fragment가 생성될 때 호출
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("test", "onCreate")
    }


    // Fragment를 통해 보옂루 View를 생성하기 위해 호출
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("test", "onCreateView")
        return inflater.inflate(R.layout.fragment_sub, null)
    }

    // 중요
    // Fragment를 통해 보열줄 View가 생성되면 호출
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("test", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    // Activity에서 보여줄 Fragment가 완전히 생성되면 호출된다.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("test", "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    // Fragment가 가동될 때 호출된다.(Fragmet가 화면에 표시될 때)
    override fun onStart() {
        Log.d("test", "onStrat")
        super.onStart()
    }

    // Fragment가 보여지고 나서 호출된다.
    override fun onResume() {
        Log.d("test", "onResume")
        super.onResume()
    }

    // Fragment가 일시 중지될때(Fragment가 화면에서 사라질 때)
    override fun onPause() {
        Log.d("test", "onPause")
        super.onPause()
    }


    // Fragment가 화면에서 완전히 사라져서 더 이상 보여지지 않을 때 호출
    // Fragment 중지
    override fun onStop() {
        Log.d("test", "onStop")
        super.onStop()
    }

    // Fragment가 제거될 때 호출된다. (해당 Activity가 종료 될 때)
    override fun onDestroy() {
        Log.d("test", "onDestory")
        super.onDestroy()
    }


    // Fragment가 Activity와 연결이 완전히 끊기기 전에 호출된다.
    override fun onDetach() {
        Log.d("test","onDetach")
        super.onDetach()
    }
}