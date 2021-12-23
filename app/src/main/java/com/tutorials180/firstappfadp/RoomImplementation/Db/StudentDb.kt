package com.tutorials180.firstappfadp.RoomImplementation.Db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tutorials180.firstappfadp.RoomImplementation.DAO.StudentDAO
import com.tutorials180.firstappfadp.RoomImplementation.DataEntities.Student
import com.tutorials180.firstappfadp.RoomImplementation.DataEntities.Teacher


//This is our database for the students table
//This class actually represents database
@Database(entities = [Student::class,Teacher::class], version = 1)
abstract class StudentDb : RoomDatabase()
{
    abstract fun getStudentDaoObject():StudentDAO
}