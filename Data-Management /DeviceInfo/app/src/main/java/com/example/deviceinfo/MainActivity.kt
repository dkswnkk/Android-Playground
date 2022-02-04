package com.example.deviceinfo

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import com.example.deviceinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val permissionList = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_SMS,
        Manifest.permission.READ_PHONE_NUMBERS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissions(permissionList, 0)

        binding.button.setOnClickListener {
            // TelephonyManager를 호출한다.
            val manager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_SMS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_NUMBERS
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                binding.textView.text = "권한을 허용해 주세요"
            } else {
                binding.textView.text = "전화번호: ${manager.line1Number}"
                binding.textView.append("SIM 국가 코드:${manager.simCountryIso}\n")
                binding.textView.append("모바일 국가코드 + 모바일 네트워크 코드: ${manager.simOperator}\n")
                binding.textView.append("서비스 이름:${manager.simOperatorName}\n")
                binding.textView.append("SIM 상태(통신 가능여부, LIN LOCK 여부:${manager.simState}\n")
                binding.textView.append("음 메일 번호:${manager.voiceMailNumber}\n")
            }
        }

        binding.button2.setOnClickListener {
            binding.textView.text = "보드 이름: ${Build.BOARD}\n"
            binding.textView.append("소프트웨어를 커스터마이징한 회사: ${Build.BRAND}\n")
            binding.textView.append("제조사 디자인명: ${Build.DEVICE}\n")
            binding.textView.append("사용자에게 표시되는 빌드 ID: ${Build.DISPLAY}\n")
            binding.textView.append("빌드 고유 ID: ${Build.ID}\n")
            binding.textView.append("ChangeList 번호: ${Build.ID}\n")
            binding.textView.append("제품/하드웨어 제조업체: ${Build.MANUFACTURER}\n")
            binding.textView.append("제품명: ${Build.PRODUCT}\n")
            binding.textView.append("빌드 구분: ${Build.TAGS}\n")
            binding.textView.append("빌드 타입: ${Build.TYPE}\n")
            binding.textView.append("안드로이드 버전 번호: ${Build.VERSION.RELEASE}\n")
        }

        binding.button3.setOnClickListener {
            val wm = getSystemService(WINDOW_SERVICE) as WindowManager

            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
                val metrix = wm.currentWindowMetrics

                val width = metrix.bounds.width()
                val height = metrix.bounds.height()

                binding.textView.text = "width: ${width}\n"
                binding.textView.append("height: ${height}\n")
            }
            else{
                val display = wm.defaultDisplay
                val point = Point()
                display.getSize(point)
                binding.textView.text = "width: ${point.x}\n"
                binding.textView.text = "height:${point.y}\n"
            }
        }
    }
}