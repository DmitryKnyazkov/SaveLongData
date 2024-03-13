package com.example.savelongdata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository(getSharedPreferences("prefs", Context.MODE_PRIVATE))

        val editText = findViewById<EditText>(R.id.edit_text)
        val button_save = findViewById<Button>(R.id.button_save)
        val button_clean = findViewById<Button>(R.id.button_clean)
        val textView = findViewById<TextView>(R.id.textView)

        fun makeTextForTextView ():String {
            return "в памяти телефона: ${repository.getDataFromSharedPreference()}"
        }
        textView.setText(makeTextForTextView())

        button_save.setOnClickListener {
            val str = editText.text.toString()
            repository.saveText(str)
            textView.setText(makeTextForTextView())
            editText.setText("")
//            textView.setText(str)
        }

        button_clean.setOnClickListener {
            repository.clearText()
            textView.setText(makeTextForTextView())
        }

    }


}