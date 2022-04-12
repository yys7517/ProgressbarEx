package com.example.progressbarex

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var pg : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pg = findViewById( R.id.pg )

        val button = findViewById<Button>(R.id.button)
        val dialog_button = findViewById<Button>(R.id.dialog_button)

        button.setOnClickListener {
            // 프로그레스 바 보여줬다가
            showProgress( true )

            // 시간 지나면 사라지게 하기
            thread( start = true ) {
                Thread.sleep( 3000 )

                runOnUiThread {
                    showProgress( false )
                    setPicture()
                }
            }
        }

        dialog_button.setOnClickListener {

            val mDialogView = LayoutInflater.from( this ).inflate( R.layout.progress_dialog , null )
            val mBuilder = AlertDialog.Builder( this )
                .setView( mDialogView )

            val mAlertDialog = mBuilder.show()

            // 시간 지나면 사라지게 하기
            thread( start = true ) {
                Thread.sleep( 3000 )

                runOnUiThread {
                    mAlertDialog.dismiss()
                    setPicture()
                }
            }
        }
    }

    private fun setPicture() {

    }

    private fun imageUpload() {
        Thread {

        }
    }
    private fun showProgress( isShow : Boolean ) {
        if( isShow ) {
            pg.visibility = View.VISIBLE
        }else {
            pg.visibility = View.GONE
        }
    }
}