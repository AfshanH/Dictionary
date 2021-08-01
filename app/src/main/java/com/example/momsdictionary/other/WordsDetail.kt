package com.example.momsdictionary.other

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import android.widget.Toast
import com.example.momsdictionary.R
import com.example.momsdictionary.db.Methods
import com.example.momsdictionary.db.WordsDatabase
import com.example.momsdictionary.db.wordss
import com.example.momsdictionary.ui.BottomSheetDialogInsurrance
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog_insurrance.*
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_words_detail.*


class WordsDetail : AppCompatActivity() {

//    val db = Methods(this)

    var model = wordss()
    val db = Methods(this)

    var bundle = Bundle()
    var words: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_detail)

        textviewsFun()

        val bottomSheetDialogInsurrance = BottomSheetDialogInsurrance()


        btn_edit.setOnClickListener {


            bottomSheetDialogInsurrance.show(supportFragmentManager, "BottomSheetDialog")


            bottomSheetDialogInsurrance.onBottomSheetClickListener =
                object : BottomSheetDialogInsurrance.OnBottomSheetClickListener {

                    override fun onBClick(id: Int) {


                        when (id) {
                            R.id.bottomsheet_yes -> {
                                editFun()
                            }

                            R.id.bottomsheet_No -> {
                              bottomSheetDialogInsurrance.dismiss()
                            }

                        }

                    }
                }
        }
        btn_delete.setOnClickListener {
            bottomSheetDialogInsurrance.show(supportFragmentManager, "BottomSheetDialog")


            bottomSheetDialogInsurrance.onBottomSheetClickListener =
                object : BottomSheetDialogInsurrance.OnBottomSheetClickListener {

                    override fun onBClick(id: Int) {


                        when (id) {
                            R.id.bottomsheet_yes -> {
                                deleteFun()
                            }

                            R.id.bottomsheet_No -> {
                                bottomSheetDialogInsurrance.dismiss()
                            }

                        }

                    }
                }
        }


    }

    private fun deleteFun() {

        db.DeleteMyWord(words!!)

        finish()

    }

    private fun editFun() {

        model = db.GetWordsdata(words)

        model.pronunciation = edt_phonetics_edit.text.toString()
        model.meaning = edt_farsiDef_edit.text.toString()
        model.example = edt_exampleWithDef_edit.text.toString()
        model.Khalaji_syn = edt_khalajiSyn_edit.text.toString()
        model.synExample = edt_exampleWithSyn_edit.text.toString()
        model.partOfSpeech = edt_PartOfSpeach_edit.text.toString().toInt()
        model.verbCount = edt_verbCount_edit.text.toString().toInt()
        model.idioms = edt_Idioms_edit.text.toString()
        model.categories = edt_Categories_edit.text.toString().toInt()

        db.UpdateMyWords(model)
        finish()

    }

    @SuppressLint("SetTextI18n")
    private fun textviewsFun() {

        bundle = intent.extras!!
        words = bundle.getString("word")

        model = db.GetWordsdata(words)

        txt_word.setText(words)
        edt_phonetics_edit.setText("${model.pronunciation}")
        edt_farsiDef_edit.setText("${model.meaning}")
        edt_exampleWithDef_edit.setText("${model.example}")
        edt_khalajiSyn_edit.setText("${model.Khalaji_syn}")
        edt_exampleWithSyn_edit.setText("${model.synExample}")
        edt_PartOfSpeach_edit.setText("${model.partOfSpeech}")
        edt_verbCount_edit.setText("${model.verbCount}")
        edt_Idioms_edit.setText("${model.idioms}")
        edt_Categories_edit.setText("${model.categories}")

//        txt_word.setText(bundle)
//        txt_details.setText("تلفظ  : ${model.pronunciation} \n معنی  : ${model.meaning} \n مترادف خلجی  : ${model.Khalaji_syn} \n" +
//                "مثال  : ${model.example} \n مثال با مترادف  : ${model.synExample} \n نقش دستوری  : ${model.partOfSpeech} " +
//                "\n صرف افعال  : ${model.verbCount} \n اصطلاحات  : ${model.idioms} \n دسته بندی ها  : ${model.categories}")

    }
}