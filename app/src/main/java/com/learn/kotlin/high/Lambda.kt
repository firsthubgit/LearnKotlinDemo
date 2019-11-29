package com.learn.kotlin.high

/**
 * Lambda 和 匿名函数 是未声明的函数
 * */
fun  main(){

    //定义一个lambda，lambda表达式总是在花括号中
    fun main(args: Array<String>) {
        //(Int, Int)表示参数类型
        // ->Int 表示返回值
        val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
        //自动推断类型的写法
        val sum = {x :Int ,y: Int -> x +y}
        println(sumLambda(1,2))  // 输出 3
    }

    //上面的Lambda表达式 等价于下面普通的命名函数
    fun compare(a: Int, b: Int) : Int {
        return a + b
    }

    //单体表达式  当函数返回的单个表达式时，
    // 可以省略花括号并且在=符号之后指定代码体
    fun compare1(a: Int, b: Int) : Int  = a + b


    //lambda  https://juejin.im/entry/58a382da61ff4b0058ab4542
    val numbers = mutableListOf("one", "two", "q","three")

    //定义一个标签
    numbers.forEach forEacBlock@{
        if(it == "q") return@forEacBlock//设置返回的位置
        println(it)
    }
    //输出 one  two  three
    //或者使用匿名函数代替lambda表达式，使return返回到函数的
    //return 从最近的使用fun关键字声明 的函数返回
    numbers.forEach(fun(value : String){
        if(value == "q"){
            return
        }
        print(value +"  ")
    })

    //如果函数只有这么一个 Lambda 表达式参数，
    //前面那个不就是么，剩下一个小括号也没什么用，干脆也丢掉吧：
    //如果该 lambda 表达式是调用时唯一的参数，那么圆括号可以完全省略
    //这个 return会直接结束main函数
    numbers.forEach{
        if(it == "q") return
        println(it)
    }


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




    //如果这个 Lambda 表达式里面只有一个函数调用，
    //并且这个函数的参数也是这个Lambda表达式的参数
    numbers.forEach(::println)




    //lambda中的返回一个值，默认最后一个表达式的值，最为返回值
    var ints = arrayOf(1,2,3,4)

    ints.filter {
        val shouldFilter = it > 0
        shouldFilter
    }

    ints.filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }

}