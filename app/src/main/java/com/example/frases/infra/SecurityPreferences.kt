package com.example.frases.infra

import android.content.Context

class SecurityPreferences(val context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)
    fun SalvarString(indice: String, valor: String) {
        mSharedPreferences.edit().putString(indice,valor).apply()
    }
    fun getString(key: String): String{
        return mSharedPreferences.getString(MotivationConstants.KEY.PERSON_NAME,"") ?: ""
    }


}