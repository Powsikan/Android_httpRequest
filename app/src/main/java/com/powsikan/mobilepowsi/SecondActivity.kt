package com.powsikan.mobilepowsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result


class SecondActivity : AppCompatActivity() {
    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var button:Button=findViewById(R.id.button_one)
        button.setOnClickListener {
            httpRequest()

        }

      textView=findViewById(R.id.text_one)

        var backButton:Button=findViewById(R.id.button_two)
        backButton.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }


    }



    fun httpRequest() {

        val httpAsync = "https://jsonplaceholder.typicode.com/todos/1"
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        println(ex)
                    }
                    is Result.Success -> {
                        val data = result.get()
                        println(data)
                        textView.text=data
                    }
                }
            }

        httpAsync.join()
    }

}
