package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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
            setNickname(it)
        }

    }

    private fun setNickname(view: View) {

        binding.apply {
            myName?.nickname = edtxtNickname.text.toString()
            txtGreetings.text = getString(R.string.greeting_message, myName?.nickname)
            invalidateAll()
            edtxtNickname.visibility = View.GONE
            txtGreetings.visibility = View.VISIBLE
            btnDone.visibility = View.GONE
            txtBio.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}