package com.example.instagram

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.instagram.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.emailLoginButton.setOnClickListener {
           signinAndsignup()
        }


    }

    fun signinAndsignup() {
        auth?.createUserWithEmailAndPassword(
            binding.emailEditText.text.toString(),
            binding.passwordEditText.toString()
        )?.addOnCompleteListener { it ->
            if (it.isSuccessful) {
                // 성공
                moveMainPage(it.result?.user)
            } else if (it.exception?.message.isNullOrEmpty()) {
                // 에러
                Toast.makeText(this,it.exception?.message,Toast.LENGTH_SHORT).show()
            } else {
                //
                signInEmail()
            }
        }
    }

    fun signInEmail() {
        auth?.signInWithEmailAndPassword(
            binding.emailEditText.text.toString(),
            binding.passwordEditText.toString()
        )?.addOnCompleteListener { it ->
            if (it.isSuccessful) {
//                 아이디와 패스워드가 일치하지 않을때
            } else{
//                 아이디와 패스워드가 틀렸을때
            }
        }
    }

    fun moveMainPage(user: FirebaseUser?){
        if(user !=null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}