package com.learn.kotlin.high

fun  main(){
    //定义一个lambda
    fun main(args: Array<String>) {
        //(Int, Int)表示参数类型
        // ->Int 表示返回值
        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        println(sumLambda(1,2))  // 输出 3
    }

    //lambda  https://juejin.im/entry/58a382da61ff4b0058ab4542
    val numbers = mutableListOf("one", "two", "q","three")

    //定义一个标签
    numbers.forEach forEacBlock@{
        if(it == "q") return@forEacBlock//设置返回的位置
        println(it)
    }
    //输出 one  two  three
    //或者使用匿名函数代替lambda表达式，使return返回到函数的
    numbers.forEach(fun(value : String){
        if(value == "q"){
            return
        }
        print(value +"  ")
    })


    numbers.forEach ({ it ->
        if(it == "q") return //这里会直接返回main函数
        println(it)
    } )
    println("The End")
    //  Kotlin 允许我们把函数的最后一个Lambda表达式参数移除括号外
    numbers.forEach (){ it ->
        if(it == "q") return
        println(it)
    }

    //如果函数只有这么一个 Lambda 表达式参数，
    //前面那个不就是么，剩下一个小括号也没什么用，干脆也丢掉吧：
    numbers.forEach{
        if(it == "q") return
        println(it)
    }


    //如果这个 Lambda 表达式里面只有一个函数调用，
    //并且这个函数的参数也是这个Lambda表达式的参数
    numbers.forEach(::println)

}