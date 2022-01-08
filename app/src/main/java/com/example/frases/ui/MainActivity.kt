package com.example.frases.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.frases.R
import com.example.frases.infra.MotivationConstants
import com.example.frases.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mSecurityPreferences = SecurityPreferences(this)
        textName.text =  mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)


    }
}