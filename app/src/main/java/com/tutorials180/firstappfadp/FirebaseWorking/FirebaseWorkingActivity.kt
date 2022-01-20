package com.tutorials180.firstappfadp.FirebaseWorking

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.firstappfadp.R

class FirebaseWorkingActivity : AppCompatActivity()
{
    private lateinit var mFirebaseFirestore:FirebaseFirestore
    private lateinit var mProgressDialog: ProgressDialog

    private lateinit var addDocumentBtn:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_working)

        mFirebaseFirestore= Firebase.firestore
        mProgressDialog= ProgressDialog(this)

        mProgressDialog.setTitle("Please wait")
        addDocumentBtn=findViewById(R.id.fb_add_document_btn)

        addDocumentBtn.setOnClickListener { addSingleDocument() }
    }


    private fun addSingleDocument()
    {
        try
        {
            mProgressDialog.show()
            var studentData=HashMap<String,Any>()
            studentData["name"]="Ali Raza"

            studentData["rollNo"]=1
            studentData["age"]=20

            mFirebaseFirestore.collection("Student")
                .add(studentData)
                .addOnSuccessListener {
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Data Added",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext,"Data Not Added",Toast.LENGTH_SHORT).show()
                }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }









}