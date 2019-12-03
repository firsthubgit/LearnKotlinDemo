package com.learn.kotlin.base

import kotlin.reflect.KFunction

fun main(){

    /**
     * 使用成员引用，使用类名引用成员函数（扩展函数）
     * 此时 Test::funtionParam的类型为 Test.(Int) -> Unit
     * */
    function1(Test::functionParam)


    /**
     * 使用绑定引用，使用对象去引用成员函数
     * 此时 test::funtionParam的类型为 (Int) -> Unit
     * */
    val test = Test()
    function2(test::functionParam)


    //报错 Found   KFunction1(@ParameterName Int, Unit)
//    function1(test::functionParam)

    //报错 Found   KFunction2(Test, @ParameterName Int, Unit)
//    function2(Test::functionParam)



}

class Test{
    fun functionParam(a : Int) = println(a)
}

fun function1(a: Test.(Int) -> Unit) = Test().a(6)
fun function2(a: (Int) -> Unit) = a(6)