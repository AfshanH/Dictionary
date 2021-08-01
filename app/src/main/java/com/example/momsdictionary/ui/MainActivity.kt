package com.example.momsdictionary.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.momsdictionary.R
import com.example.momsdictionary.other.WordsAdapter
import com.example.momsdictionary.db.Helper
import com.example.momsdictionary.db.Methods
import com.example.momsdictionary.other.WordsDetail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        funMethod()
    }

    override fun onResume() {
        super.onResume()

        val db = Methods(applicationContext)
        val wordItems = db.getData()
        val help = Helper()
        val wordLists = help.words(wordItems)
        val wordsMean = help.wordsMean(wordItems)

        val wordAdapter =
            WordsAdapter(applicationContext, wordLists,wordsMean, object : WordsAdapter.Interaction {
                override fun onItemSelected(position: Int) {
                    val select = wordLists.get(position)

                    val intent = Intent(this@MainActivity , WordsDetail::class.java)
                    with(intent){
                        putExtra("word" , select)
                    }
                    startActivity(intent)
                }

            })


        rec_list.layoutManager = LinearLayoutManager(applicationContext)
        rec_list.adapter = wordAdapter
    }


    private fun funMethod() {

        btn_add.setOnClickListener {
            val intent = Intent(this, Insert::class.java)
            startActivity(intent)
        }
    }
}