package com.example.systemmessage

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            "android.intent.action.BOOT_COMPLETED" -> {
                Toast.makeText(context, "부팅완료", Toast.LENGTH_SHORT).show()
            }
            "android.provider.Telephony.SMS_RECEIVED" -> {
                if (intent.extras != null) {
                    // 문자 메시지 정보 객체를 추출한다.
                    val pduObjects = intent.extras?.get("pdus") as Array<Any?>
                    if (pduObjects != null) {
                        for (obj in pduObjects) {
                            // 문자메시지 양식 객체를 추출한다.
                            val format = intent.extras?.getString("format")
                            // 문자메시지 객체를 생성한다.
                            val currentSMS = SmsMessage.createFromPdu(obj as ByteArray?, format)

                            val showMessage =
                                "전화번호 ${currentSMS.displayOriginatingAddress}\n 내용: ${currentSMS.displayMessageBody}"
                            Toast.makeText(context, showMessage, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }


        }
    }
}