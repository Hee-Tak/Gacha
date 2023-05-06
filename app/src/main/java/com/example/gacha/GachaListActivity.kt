package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class GachaListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gacha_list)

        //ListView를 가져와서 Adapter와 연결
        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getListData())
        listView.adapter = adapter

        val button = findViewById<Button>(R.id.back_and_home)
        button.setOnClickListener{
            onBackPressed()
        }
    }

    //목록 데이터를 반환하는 메서드
    private fun getListData(): List<String>{
        val data = ArrayList<String>()
        data.add("일반 / 탈것 펫 가챠")
        data.add("전투 펫 가챠")
        return data
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }



}