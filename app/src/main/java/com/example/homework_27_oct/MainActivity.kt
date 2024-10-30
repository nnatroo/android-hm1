package com.example.homework_27_oct

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val yourEmailEditText = findViewById<EditText>(R.id.yourEmailEditText)
        val recipientEmailEditText = findViewById<EditText>(R.id.recipientEmailEditText)
        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val yourEmail = yourEmailEditText.text.toString()
            val recipientEmail = recipientEmailEditText.text.toString()
            val message = messageEditText.text.toString()

            if (yourEmail.contains("@") && recipientEmail.contains("@") && message.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java)
                intent.putExtra("recipientEmail", recipientEmail)
                intent.putExtra("senderEmail", yourEmail)
                intent.putExtra("message", message)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter valid email addresses and message", Toast.LENGTH_SHORT).show()
            }
        }

    }
}