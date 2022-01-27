package com.example.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class SubFragment : DialogFragment() {

    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = activity as MainActivity
        Log.d("test", "3")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("test", "4")
        val builder =
            AlertDialog.Builder(mainActivity).setTitle("타이틀입니다.").setMessage("메시지입니다.")
                .setPositiveButton("수락") { dialogInterface: DialogInterface, i: Int ->
                    mainActivity.binding.textView1.text = "Positive"
                }.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
                    mainActivity.binding.textView1.text = "Neutral"
                }.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
                    mainActivity.binding.textView1.text = "Negative"
                }
        Log.d("test", "5")
        val alert = builder.create()
        Log.d("test", "6")
        return alert
    }
}