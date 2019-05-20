package com.learn.kotlin


fun get(x : Int) : Int = when(x){
        1 -> 1
        else -> 0
    }

fun main(){
    println(get(1))
    println(get(0))

}


