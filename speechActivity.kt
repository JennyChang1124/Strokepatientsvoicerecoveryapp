package com.example.strokepatientsvoicerecoveryapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class speechActivity : AppCompatActivity() {
    private val SPEECH_REQUEST_CODE = 0   //秘密代號=0

    private val selectData =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val data = result.data
            }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speech)
        displaySpeechRecognizer()  //app一開始跑就會被呼叫
    }

    private fun displaySpeechRecognizer() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            /*
            putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            */
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Listening...")  //設定語音辨識畫面顯示標題
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "zh-TW") //設定語言
            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)   //返回結果數
        }
        startActivityForResult(intent, SPEECH_REQUEST_CODE)   //啟動語音辨識活動 呼叫特定頁面回報結果
    }
    //舊方法
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                    results?.get(0)
                }
            Toast.makeText(this,spokenText,Toast.LENGTH_SHORT).show()
        }
    }




}