package com.example.tugasuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen dari layout
        val editUsername = findViewById<EditText>(R.id.editUsername)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editFirstName = findViewById<EditText>(R.id.editFirstName)
        val editLastName = findViewById<EditText>(R.id.editLastName)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val editConfirmPassword = findViewById<EditText>(R.id.editPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        // Tombol Submit
        btnSubmit.setOnClickListener {
            val username = editUsername.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val firstName = editFirstName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val password = editPassword.text.toString().trim()
            val confirmPassword = editConfirmPassword.text.toString().trim()

            // Validasi input
            when {
                username.isEmpty() || email.isEmpty() ||
                        firstName.isEmpty() || lastName.isEmpty() ||
                        password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                }

                password != confirmPassword -> {
                    Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    val fullName = "$firstName $lastName"
                    Toast.makeText(this, "Pendaftaran berhasil: $fullName", Toast.LENGTH_LONG).show()
                }
            }
        }

        // Tombol Batal (reset semua input)
        btnCancel.setOnClickListener {
            editUsername.text.clear()
            editEmail.text.clear()
            editFirstName.text.clear()
            editLastName.text.clear()
            editPassword.text.clear()
            editConfirmPassword.text.clear()
            Toast.makeText(this, "Form dibersihkan", Toast.LENGTH_SHORT).show()
        }
    }
}
