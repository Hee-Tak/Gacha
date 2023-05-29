package com.example.gacha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

private lateinit var imageView: ImageView
private lateinit var timer: Timer
private var fishingStarted: Boolean = false
private var fishingSuccess: Boolean = false
private lateinit var timeText: TextView
private lateinit var timeText2: TextView
private var countDownTimer: CountDownTimer? = null //CountDownTimer 객체를 저장하는 변수 추가
private lateinit var failedTask: TimerTask



class FishingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fishing)

        val button = findViewById<Button>(R.id.back_and_home)
        button.setOnClickListener {
            onBackPressed()
            Toast.makeText(this, "뒤로!", Toast.LENGTH_SHORT).show()
        }

        //timeText 변수 초기화
        timeText = findViewById(R.id.timeText)
        timeText2 = findViewById(R.id.timeText2) //카운트다운용도


        //클릭하면 이미지가 변경되도록 설정
        imageView = findViewById<ImageView>(R.id.imageView)
        imageView.tag = "fishing1"
        imageView.setOnClickListener {
            if(fishingStarted){
                if(imageView.tag == "fishing2"){
                    fishingSuccess = false
                    stopAutoChangeImage()
                    Handler(mainLooper).postDelayed({
                        imageView.setImageResource(R.drawable.fishing1)
                        imageView.tag == "fishing1"
                        fishingStarted = false
                        fishingSuccess = false
                        Toast.makeText(this, "낚시 실패! 좀 더 기다리세요.", Toast.LENGTH_SHORT).show()
                        countDownTimer?.cancel()
                    },500)
                }
                else if(imageView.tag == "fishing3"){
                    fishingSuccess = true
                    stopAutoChangeImage()
                    Handler(mainLooper).postDelayed({
                        if(fishingSuccess){
                            imageView.setImageResource(R.drawable.fishing1)
                            imageView.tag = "fishing1"
                            fishingStarted = false
                            fishingSuccess = false
                            Toast.makeText(this, "낚시 성공!", Toast.LENGTH_SHORT).show()

                            failedTask.cancel()
                            timer.cancel()
                        }
                    }, 500)
                }

            } else {
                startFishing()
            }
        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun startFishing(){
        fishingStarted = true
        imageView.setImageResource(R.drawable.fishing2)
        imageView.tag = "fishing2"
        startAutoChangeImage()
    }

    private fun changeImage() {
        when (imageView.tag) {
            "fishing2" -> {
                imageView.setImageResource(R.drawable.fishing3)
                imageView.tag = "fishing3"
            }
            "fishing3" -> {
                imageView.setImageResource(R.drawable.fishing1)
                imageView.tag = "fishing1"
                fishingStarted = false
                fishingSuccess = false
                Toast.makeText(this, "낚시 실패!", Toast.LENGTH_SHORT).show()
                countDownTimer?.cancel()

            }

        }
    }

    fun changeImage(view: View) {
        changeImage()
    }

    private fun startAutoChangeImage() {
        val random = Random()
        val delay = (5..8).random() * 1000L //랜덤 시간 설정
        val countDownInterval = 1000L //카운트 다운 주기
        timeText.text = "SETUP 시간: ${(delay/1000)}초"

        countDownTimer = object: CountDownTimer(delay, countDownInterval){
            override fun onTick(millisUntilFinished: Long){
                val seconds = (millisUntilFinished / 1000).toInt()
                timeText2.text = "남은 시간: ${seconds}초"
            }

            override fun onFinish() {
                timeText2.text = "---끝---"
            }
        }.start()

        failedTask = object: TimerTask() {
            override fun run() {
                Handler(mainLooper).post {
                    changeImage()
                    if(imageView.tag == "fishing3"){
                        stopAutoChangeImage()
                        Handler(mainLooper).postDelayed({
                            if(imageView.tag == "fishing3"){
                                imageView.setImageResource(R.drawable.fishing1)
                                imageView.tag = "fishing1"
                                fishingStarted = false
                                fishingSuccess = false
                                Toast.makeText(this@FishingActivity, "낚시 실패! 물고기 도망갔어요ㅠ.", Toast.LENGTH_SHORT).show()

                            }
                            },6000)
                    }
                }
            }
        }
        timer = Timer()
        timer.schedule(failedTask , delay)

    }

    private fun stopAutoChangeImage(){
        //countDownTimer?.cancel() //CountDownTimer 객체를 취소
        timer.cancel()
        failedTask.cancel()
        timeText.text ="*******"
        timeText2.text="*******"
    }
    //=============================================================
    override fun onDestroy() {
        super.onDestroy()
        //countDownTimer?.cancel() //CountDownTimer 객체를 취소
        timer.cancel() // 타이머 종료
        timeText.text="+++++++"
        timeText2.text="+++++++"
    }
    //============================================================
}


/*
    //이미지 자동 변경 함수
    fun autoChangeImage(){
        timer = Timer()

        //TimerTask 클래스를 상속받은 객체를 생성하여 Timer 클래스에 등록합니다.
        val task: TimerTask = object: TimerTask(){
            override fun run(){
                runOnUiThread{
                    //UI스레드에서 이미지 변경 함수를 호출합니다.
                    changeImage()
                }
            }
        }

        //타이머를 5~10초 사이 랜덤으로 설정합니다.
        val random = Random().nextInt(6) + 5
        timer?.schedule(task, random.toLong() * 1000)
    }
*/




