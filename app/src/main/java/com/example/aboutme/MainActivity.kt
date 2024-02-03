package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Livia Carvalho")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
        val doneButton: Button = binding.btnDone
        doneButton.setOnClickListener {
            setNickname()
        }

    }

    private fun setNickname() {

        binding.apply {
            myName?.nickname = edtxtNickname.text.toString()
            txtGreetings.text = getString(R.string.greeting_message, myName?.nickname)
            invalidateAll()
            edtxtNickname.visibility = View.GONE
            txtGreetings.visibility = View.VISIBLE
            btnDone.visibility = View.GONE
        }
    }
}