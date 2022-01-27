package com.tutorials180.firstappfadp.FirebaseWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tutorials180.firstappfadp.R

class FirebaseAuthActivity : AppCompatActivity()
{
    private lateinit var emailET:EditText
    private lateinit var passwordET:EditText

    private lateinit var signUpUserBtn:Button
    private lateinit var mFirebaseAuth : FirebaseAuth

    private lateinit var signInUserBtn:Button
    private lateinit var signOutUserBtn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_auth)

        mFirebaseAuth = Firebase.auth

        emailET = findViewById(R.id.fb_auth_email_et)
        passwordET = findViewById(R.id.fb_auth_password_et)

        signUpUserBtn = findViewById(R.id.fb_sign_up_user_btn)
        signInUserBtn = findViewById(R.id.fb_auth_sign_in_user_btn)

        signOutUserBtn = findViewById(R.id.fb_auth_sign_out_user_btn)

        signUpUserBtn.setOnClickListener {

            val userEmail=emailET.text.toString()
            val userPassword = passwordET.text.toString()

            if(userEmail.isNotBlank() && userPassword.isNotBlank())
            {
                mFirebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword)
                    .addOnCompleteListener {
                        if(it.isSuccessful)
                        {
                            Toast.makeText(applicationContext, "User is registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "Error:${it.exception?.message}", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            else
            {
                Toast.makeText(applicationContext, "Some fields are empty", Toast.LENGTH_SHORT).show();
            }
        }
        signInUserBtn.setOnClickListener {

            val userEmail = emailET.text.toString()
            val userPassword = passwordET.text.toString()

            if(userEmail.isNotBlank() && userPassword.isNotBlank())
            {
                mFirebaseAuth.signInWithEmailAndPassword(userEmail,userPassword)
                    .addOnCompleteListener {
                        if(it.isSuccessful)
                        {
                            Toast.makeText(applicationContext, "User is logged in", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "Error:${it.exception?.message}", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            else
            {
                Toast.makeText(applicationContext, "Some fields are empty", Toast.LENGTH_SHORT).show();
            }
        }

        signOutUserBtn.setOnClickListener {

            val currentUser = FirebaseAuth.getInstance().currentUser
            if(currentUser==null)
            {
                Toast.makeText(applicationContext, "No user is logged in", Toast.LENGTH_SHORT).show();
            }
            else
            {
                FirebaseAuth.getInstance().signOut()
                Toast.makeText(applicationContext, "User is logged out", Toast.LENGTH_SHORT).show();
            }
        }
    }

















}