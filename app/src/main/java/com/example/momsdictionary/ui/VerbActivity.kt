package com.example.momsdictionary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.momsdictionary.R
import kotlinx.android.synthetic.main.activity_verb.*

class VerbActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb)

        var list = arrayOf(
            "گذشته ساده",
            "گذشته نقلی",
            "گذشته بعید",
            "گذشته استمراری",
            "گذشته التزامی",
            "گذشته ابعد",
            "گذشته نقلی استمراری",
            "گذشته ملموس",
            "حال ساده",
            "حال اخباری",
            "حال التزامی",
            "آینده",
            "امری",
            "نهی"
        )

        var arrAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView_verb.adapter = arrAdapter

        listView_verb.setOnItemClickListener { parent, view, position, id ->

            if (position==12 || position==13){

//                I.visibility =View.GONE
//                she.visibility = View.GONE
//                we.visibility = View.GONE
//                they.visibility = View.GONE
            }

            val dialogBuilder = AlertDialog.Builder(this)
            val dialog : AlertDialog
            val view : View = layoutInflater.inflate(R.layout.verb_count_popup,null)

            dialogBuilder.setView(view)
            dialog = dialogBuilder.create()

            dialog.show()

//            Toast.makeText(this, "${list[position]}", Toast.LENGTH_SHORT).show()
        }

    }
}