package com.tutorials180.firstappfadp

import java.io.Serializable

class Student (var id:Int,var name:String,
var dob:String,var email:String)
    :Serializable{
    var uId:Int=id
    var uName:String=name

    var uDob:String=dob
    var uEmail:String=email


}