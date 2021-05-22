package com.example.momsdictionary.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.momsdictionary.R
import com.example.momsdictionary.db.Entities.Words_Entity
import com.example.momsdictionary.db.WordsDataBase
import kotlinx.android.synthetic.main.activity_insert.*

class Insert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)


        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_insert.setOnClickListener{

        }

        Categories.setOnClickListener { popupCategory() }

        PartOfSpeach.setOnClickListener { popupParts() }

        verbCount.setOnClickListener {
            val intent = Intent(this, VerbActivity::class.java)
            startActivity(intent)
        }
    }

    private fun insertInfo(){

        var wordsDataBase : WordsDataBase? = null

        val word = word.text.toString()
        val pronounciation = phonetics.text.toString()
        val farsi_def = farsiDef.text.toString()
        val example = exampleWithDef.text.toString()
        val khalaji_syn = khalajiSyn.text.toString()
        val example_syn = exampleWithSyn.text.toString()
        val partOfSpeech = PartOfSpeach.text.toString().toInt()
        val verbCount = verbCount.text
        val idioms = Idioms.text.toString()
        val Categoriy = Categories.text.toString()


        val datas = Words_Entity(word , pronounciation, farsi_def , example, khalaji_syn, example_syn, partOfSpeech , verbCount ,idioms , Categoriy)

        if (datas!= null){
            WordsDataBase(applicationContext).wordsDao().insertWord(datas)
        }



    }

    private fun popupCategory() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog : AlertDialog
        val view : View = layoutInflater.inflate(R.layout.categories,null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun popupParts() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog : AlertDialog
        val view : View = layoutInflater.inflate(R.layout.part_of_speech,null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }

    private fun popupVerb() {

        val dialogBuilder = AlertDialog.Builder(this)
        val dialog : AlertDialog
        val view : View = layoutInflater.inflate(R.layout.activity_verb,null)

        dialogBuilder.setView(view)
        dialog = dialogBuilder.create()
        dialog.show()
    }
}