package com.example.gacha

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        init()


    }

    private fun init() {
        /*
        //로딩 화면 표시
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        */

        Handler().postDelayed({
            val intent = Intent(this@LoadingActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)
    }
}