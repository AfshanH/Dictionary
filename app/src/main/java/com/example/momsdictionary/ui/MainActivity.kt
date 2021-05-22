package com.example.momsdictionary.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.momsdictionary.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        funMethod()
    }

    private fun funMethod() {

        btn_add.setOnClickListener{
            val intent = Intent(this, Insert::class.java)
            startActivity(intent)
        }
    }
}