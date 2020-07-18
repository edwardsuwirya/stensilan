package com.enigmacamp.stensilan.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.enigmacamp.stensilan.R

class ProgressBarModal {

    companion object {
        fun progressBar(context: Context): AlertDialog {
            val inflate = LayoutInflater.from(context).inflate(R.layout.layout_progressbar, null)
            val dialog = AlertDialog.Builder(context).setView(inflate).setCancelable(false).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return dialog
        }
    }
}