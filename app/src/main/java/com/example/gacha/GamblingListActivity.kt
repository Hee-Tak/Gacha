package com.example.gacha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class GamblingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gambling_list)

        val button = findViewById<Button>(R.id.back_and_home)
        button.setOnClickListener{
            onBackPressed()
        }


        //ListView를 가져와서 Adapter와 연결
        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, getListData())
        listView.adapter = adapter


        listView.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            when(position){
                0 -> {
                    val intent = Intent(this, ThreeCardMonteGamblingActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, FlowerGamblingActivity::class.java)
                    startActivity(intent)
                }

                else -> {

                }

            }
        }
        //========================================================================================

        val listView1 = findViewById<ListView>(R.id.powerUp)
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, getListData1())
        listView1.adapter = adapter1

        listView1.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            when(position){
                0 -> {
                    val intent = Intent(this, WeaponReforgingActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this, ArmorWorkActivity::class.java)
                    startActivity(intent)
                }
                else -> {

                }
            }
        }






    }

    //목록 데이터를 반환하는 메서드
    private fun getListData(): List<String>{
        val data = ArrayList<String>()
        data.add("야바위 도박")
        data.add("꽃 도박")
        return data
    }

    private fun getListData1(): List<String>{
        val data = ArrayList<String>()
        data.add("무기 강화")
        data.add("방어구 세공")
        return data
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }






}








