package com.learn.kotlin.base

fun main(){

    //当i==5 j==5时，结束循环
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            print(i.toString()+"&"+j.toString() + " ")
            if (i==5 && j==5) break@loop
        }
    }
}