package com.learn.kotlin.base

/**
 * 数组的创建两种方式：
 *      一种是使用函数arrayOf()
 *      另外一种是使用工厂函数
 * */
fun main(){


    //数组创建方式一
    val aI = arrayOf(1,2,3);
    aI.forEach{
        println(it)
    }

    //aII返回类型是IntArray类型
    val aII = intArrayOf(1, 2, 3)

    //arrayOfNulls<数据类型>(长度)，默认值都是null
    val fixedSizeArr = arrayOfNulls<Int>(6)

    //////////////////////////////////////////////////////////////////////////////////////

    //数组创建方式二
    val bI = Array(3,{it *2})
    bI.forEach {
        println(it)
    }

    //创建数组长度为3，元素均为""。
    val size = 3
    val cI = Array(size){""}
    cI.forEach {
        println(it + "cI")
    }

    //创建空数组
    val empty = emptyArray<Int>()


    //对象数组创建方式
    class Bean {}
    val beanArr = emptyArray<Bean>() //空数组
    val beanArray  = Array<Bean>(3, {Bean()})

    //[] 运算符代表调用成员函数 get() 和 set()
    cI[0] = "1"
    cI.set(0, "2")


    //注意: 与 Java 不同的是，Kotlin 中数组是不型变(协变)的（invariant）
    open class A{
    }
    class B : A {
        constructor() : super(){
        }
    }
    class B2 : A(){
    }
//    class B3 : A{}//ERROR

    val bArray  = Array<B>(3, {B()})
    val aArray = emptyArray<A>() //空数组
//    val aArray = bArray  //ERROR  不协变




}