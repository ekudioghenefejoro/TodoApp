 package com.oghenefejiro.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

         val username = "admin"
         val password = "admin"
         private lateinit var usernameInput: EditText
         private lateinit var passwordInput: EditText
         private lateinit var submitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usernameInput = findViewById(R.id.UserNameInput)
        passwordInput = findViewById(R.id.passwordInput)
        submitButton= findViewById(R.id.submitButton)
        submitButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Login(username, password)
        }
    }

     private fun Login (username: String, password : String) {
         if (isvalidCredentials(username, password)) {
             val intent: Intent = Intent(this, HomeActivity::class.java)
             intent.putExtra("name", username)
             startActivity(intent)

         }
         else {
             Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
         }

     }
private fun isvalidCredentials ( username : String, password: String) : Boolean {
    if (username  == username && password == password) return true
    return false
}

 }