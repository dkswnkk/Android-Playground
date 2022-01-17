package com.example.permission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.permission.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val permission_list = arrayOf(
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.READ_CONTACTS,
        android.Manifest.permission.WRITE_CONTACTS,
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView1.text = ""

        for(permission in permission_list){
            val check = checkCallingOrSelfPermission(permission)

            if(check==PackageManager.PERMISSION_GRANTED){
                binding.textView1.append("${permission}: 허용\n")
            }else if(check==PackageManager.PERMISSION_DENIED){
                binding.textView1.append("${permission}: 거부\n")
            }
        }
        binding.button.setOnClickListener {
            //거부 되어 있는 권한들을 사용자에게 확인받는다.
            requestPermissions(permission_list,0)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            binding.textView1.text=""
            for(idx in grantResults.indices){
                if(grantResults[idx]==PackageManager.PERMISSION_GRANTED){
                    binding.textView1.append("${permissions[idx]}: 허용\n")
                }
                else if(grantResults[idx]==PackageManager.PERMISSION_DENIED){
                    binding.textView1.append("${permissions[idx]}: 거부\n")
                }
            }

    }
}