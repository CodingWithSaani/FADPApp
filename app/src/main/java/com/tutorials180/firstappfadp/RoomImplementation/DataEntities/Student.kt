package com.tutorials180.firstappfadp.RoomImplementation.DataEntities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StudentRecord")
data class Student(@PrimaryKey val id:Int, @ColumnInfo(name = "studentName") val name:String, val email:String)
