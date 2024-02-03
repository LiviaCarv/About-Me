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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val doneButton: Button = binding.btnDone
        doneButton.setOnClickListener {
            setNickname()
        }

    }

    private fun setNickname() {

        binding.apply {
            txtNickname.text = getString(R.string.greeting_message, binding.edtxtNickname.text)
            invalidateAll()
            edtxtNickname.visibility = View.GONE
            txtNickname.visibility = View.VISIBLE
            btnDone.visibility = View.GONE

        }


    }
}