package com.example.momsdictionary.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.momsdictionary.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog_insurrance.*

class BottomSheetDialogInsurrance() : BottomSheetDialogFragment(){

    lateinit var onBottomSheetClickListener : OnBottomSheetClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return LayoutInflater.from(context).inflate(R.layout.activity_bottom_sheet_dialog_insurrance,container ,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomsheet_yes.setOnClickListener {
            onBottomSheetClickListener.onBClick(it.id)
        }

        bottomsheet_No.setOnClickListener {
            onBottomSheetClickListener.onBClick(it.id)
        }

    }

    interface OnBottomSheetClickListener{
        fun onBClick( id : Int)
    }

}