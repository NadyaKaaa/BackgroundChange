package com.nadyaka.backgroundchange

import android.content.DialogInterface
import android.graphics.Color.red
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayOf(getText(R.string.red),
                getText(R.string.yellow), getText(R.string.green)
        )

        button.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.message)
            builder.setItems(items, DialogInterface.OnClickListener { dialogInterface, i ->
                when (i){
                    0 -> { root.setBackgroundResource(R.color.red)}
                    1 -> {root.setBackgroundResource(R.color.yellow)}
                    2 -> {root.setBackgroundResource(R.color.green)}
                    else -> {root.setBackgroundResource(R.color.white)}
                }

                Toast.makeText(this, items[i], Toast.LENGTH_LONG).show();
            })
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}