package com.tutorials180.firstappfadp.RoomImplementation.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tutorials180.firstappfadp.RoomImplementation.DataEntities.Student

@Dao
interface StudentDAO
{
    @Insert
    fun addStudent(ucpStudent: Student):Long

    @Query("select * from StudentRecord")
    fun getAllStudents():List<Student>

}



//Room Lib => Alternative SQLite
/*
    1- Database : It will provide database
    2- Entities : Entities represent tables
    3- DAOs     : Data access object(s): We use these object to perform different operations on
                  table of the database such inserting, deleting etc.


    Example: Student.. insert, retrieve
    Step 1: We implemented the separate package => RoomImplementation
    Step 2: We created separate packages for DAO, DataEntities and for Db
    Step 3: We created student table inside DataEntities package.
    Step 4: We created DAO for the student table.
    Step 5: We created Database in which we stored our tables

    StudentRecord
    Id	studentName	studentEmail
    1	A	a@gmail.com
    2	B	b@gmail.com





 */