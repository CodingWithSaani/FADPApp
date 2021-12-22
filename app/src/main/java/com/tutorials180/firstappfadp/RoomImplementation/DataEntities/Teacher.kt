package com.tutorials180.firstappfadp.RoomImplementation.DataEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(@PrimaryKey val id:Int,val teacherName:String)
