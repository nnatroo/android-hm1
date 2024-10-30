package com.example.homework_27_oct

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val recipientEmailEditText = findViewById<TextView>(R.id.recipientEmailEditText)
        val senderEmailEditText = findViewById<TextView>(R.id.yourEmailEditText)
        val messageEditText = findViewById<TextView>(R.id.messageEditText)
        val clearButton = findViewById<Button>(R.id.clearButton)

        val recipientEmail = intent.getStringExtra("recipientEmail")
        val senderEmail = intent.getStringExtra("senderEmail")
        val message = intent.getStringExtra("message")

        recipientEmailEditText.text = "To: $recipientEmail"
        senderEmailEditText.text = "From: $senderEmail"
        messageEditText.text = "Message: $message"

        clearButton.setOnClickListener {
            senderEmailEditText.text = ""
            recipientEmailEditText.text = ""
            messageEditText.text = ""
            Toast.makeText(this, "Cleared successfully", Toast.LENGTH_SHORT).show()
        }

    }
}