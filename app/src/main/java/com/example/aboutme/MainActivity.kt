package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doneButton: Button = findViewById(R.id.btn_done)
        doneButton.setOnClickListener {
            setNickname(it)
        }

    }

    private fun setNickname(view: View) {
        val nicknameTxt: TextView = findViewById(R.id.txt_nickname)
        val nicknameEditText: EditText = findViewById(R.id.edtxt_nickname)
        nicknameTxt.text = getString(R.string.greeting_message, nicknameEditText.text)
        nicknameEditText.visibility = View.GONE
        nicknameTxt.visibility = View.VISIBLE
        view.visibility = View.GONE

    }
}