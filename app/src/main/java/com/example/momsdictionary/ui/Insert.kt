package com.example.momsdictionary.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.momsdictionary.R
import com.example.momsdictionary.db.AllWordsModel
import com.example.momsdictionary.db.Methods
import com.example.momsdictionary.db.Tables.word
import com.example.momsdictionary.db.WordsDatabase
import com.example.momsdictionary.db.wordss
//import com.example.momsdictionary.db.WordsDataBase
import kotlinx.android.synthetic.main.activity_insert.*

class Insert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)




        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_insert.setOnClickListener {

            insertInfo()
            Log.i("innnnnnnn", "onCreate: ")
                finish()

        }

//        Categories.setOnClickListener { popupCategory() }

//        PartOfSpeach.setOnClickListener { popupParts() }

//        edt_verbCount.setOnClickListener {
//            val intent = Intent(this, VerbActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun insertInfo(): Boolean {


        val methods = Methods(applicationContext)

        try {
            val datas = wordss(
                edt_word.text.toString(),
                edt_phonetics.text.toString(),
                edt_farsiDef.text.toString(),
                edt_exampleWithDef.text.toString(),
                edt_khalajiSyn.text.toString(),
                edt_exampleWithSyn.text.toString(),
                edt_PartOfSpeach.text.toString().toInt(),
                edt_verbCount.text.toString().toInt(),
                edt_Idioms.text.toString(),
                edt_Categories.text.toString().toInt()
            )


            methods.insertWords(datas)

        } catch (e: Exception) {

        }


        return true
    }

    private fun popupCategory() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog: AlertDialog
        val view: View = layoutInflater.inflate(R.layout.categories, null)


//        var value =

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun popupParts() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog: AlertDialog
        val view: View = layoutInflater.inflate(R.layout.part_of_speech, null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun popupVerb() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog: AlertDialog
        val view: View = layoutInflater.inflate(R.layout.activity_verb, null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }
}