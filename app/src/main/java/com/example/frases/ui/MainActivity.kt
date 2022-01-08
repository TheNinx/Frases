package com.example.frases.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.frases.R
import com.example.frases.infra.MotivationConstants
import com.example.frases.infra.SecurityPreferences
import com.example.frases.repositorio.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter : Int = MotivationConstants.FILTROFRASES.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        mSecurityPreferences = SecurityPreferences(this)
        textName.text = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)

        gerarNovaFrase.setOnClickListener(this)
        todasFrase.setOnClickListener(this)
        frasesFelizes.setOnClickListener(this)
        frasesBomdia.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        val id = view?.id

        val listFilter = listOf(R.id.todasFrase, R.id.frasesFelizes, R.id.frasesBomdia)
        if (id == R.id.gerarNovaFrase) {
            handleNewPhrase()

        } else if (id in listFilter) {
            if (id != null) {
                handleFilter(id)
            }
        }
    }

    private fun handleFilter(id: Int) {

        todasFrase.setColorFilter(R.color.white)
        frasesFelizes.setColorFilter(R.color.white)
        frasesBomdia.setColorFilter(R.color.white)

        when (id) {
            R.id.todasFrase -> {
                todasFrase.setColorFilter(R.color.colorAccent)
                mPhraseFilter = MotivationConstants.FILTROFRASES.ALL


            }
            R.id.frasesFelizes -> {
                frasesFelizes.setColorFilter(R.color.colorAccent)
                mPhraseFilter = MotivationConstants.FILTROFRASES.HAPPY

            }
            R.id.frasesBomdia -> {
                frasesBomdia.setColorFilter(R.color.colorAccent)
                mPhraseFilter = MotivationConstants.FILTROFRASES.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
            fraseTexto.text = Mock().getPhrase(mPhraseFilter)
    }
}