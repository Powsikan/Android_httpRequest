package com.powsikan.mobilepowsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var i=1
        var button: Button = findViewById(R.id.button_one)
        var textView: TextView = findViewById(R.id.text_one)

        button.setOnClickListener {

            Toast.makeText(this,"button clicked $i", Toast.LENGTH_SHORT).show()

            text_one.text = "hello $i"
            i++


            if (i==5){
                var intent= Intent(this,SecondActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
