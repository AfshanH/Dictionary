package com.example.momsdictionary.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.momsdictionary.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog_insurrance.*

class BottomSheetDialogInsurrance(onBottomSheetClickListener: OnBottomSheetClickListener) : BottomSheetDialogFragment() {

    lateinit var onBottomSheetClickListener : OnBottomSheetClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = LayoutInflater.from(context).inflate(R.layout.activity_bottom_sheet_dialog_insurrance,container ,false)
        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {

        bottomsheet_yes.setOnClickListener {
            onBottomSheetClickListener.onBClick(view.id)
        }

        bottomsheet_No.setOnClickListener {
            onBottomSheetClickListener.onBClick(view.id)
        }

    }

    interface OnBottomSheetClickListener{
        fun onBClick( id : Int)
    }

}