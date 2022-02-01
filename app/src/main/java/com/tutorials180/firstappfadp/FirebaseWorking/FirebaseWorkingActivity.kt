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
    private lateinit var addDocumentWithIDBtn:Button

    private lateinit var getSingleDocWithIDBtn:Button
    private lateinit var deleteSingleDocBtn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_working)

        mFirebaseFirestore= Firebase.firestore
        mProgressDialog= ProgressDialog(this)

        mProgressDialog.setTitle("Please wait")
        addDocumentBtn=findViewById(R.id.fb_add_document_btn)

        addDocumentWithIDBtn = findViewById(R.id.fb_add_document_with_id_btn)
        getSingleDocWithIDBtn = findViewById(R.id.fb_get_doc_with_id_btn)

        deleteSingleDocBtn = findViewById(R.id.fb_delete_doc_with_id_btn)

        addDocumentBtn.setOnClickListener { addSingleDocument() }
        addDocumentWithIDBtn.setOnClickListener { addSingleDocumentWithId() }

        getSingleDocWithIDBtn.setOnClickListener { fetchSingleDocument() }
        deleteSingleDocBtn.setOnClickListener { deleteSingleDocument() }
    }


    private fun addSingleDocument()
    {
        try
        {
            mProgressDialog.show()
            val studentData=HashMap<String,Any>()
            studentData["name"]="Irfan Khan"

            studentData["rollNo"]=10
            studentData["age"]=40

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

    private fun addSingleDocumentWithId()
    {
        try
        {
            mProgressDialog.show()
            val sikandarDoc = HashMap<String,Any>()
            sikandarDoc["name"] = "Sikandar Khan"

            sikandarDoc["age"] = 22
            sikandarDoc["rollNo"] = 100

            mFirebaseFirestore.collection("Student").document("Sikandar").set(sikandarDoc)
                .addOnSuccessListener {_:Void? ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Data is added", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {ex ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Data is not added:+ ${ex.message}", Toast.LENGTH_SHORT).show()
                }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchSingleDocument()
    {
        try
        {
            mProgressDialog.show()
            mFirebaseFirestore.collection("Student").document("DqAUQug4IYPBDJihafph")
                .get()
                .addOnSuccessListener { doc ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Name : ${doc["name"]}," +
                            "Rollno : ${doc["rollNo"]}, Age : ${doc["age"]}", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { ex ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show()
                }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "Exception while fetching data: ${ex.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteSingleDocument()
    {
        try
        {
            mProgressDialog.show()
            mFirebaseFirestore.collection("Student").document("awais")
                .delete()
                .addOnSuccessListener { _:Void? ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Document is deleted", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { ex ->
                    mProgressDialog.dismiss()
                    Toast.makeText(applicationContext, "Error while deleting : ${ex.message}", Toast.LENGTH_SHORT).show()
                }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show()
        }
    }




}