package com.learn.kotlin.clazzobj

import android.icu.lang.UCharacter.GraphemeClusterBreak.T


/**
 * 泛型：参数化类型。  可以接收不同类型的参数。
 *
 *  Java 中的泛型是不型变的，这意味着 List<String> 并不是 List<Object> 的子类型
 *  因为Java泛型在编译时的类型擦除。数组没有在编译时类型擦除
 *
 *
 * 泛型上界  ？ extend A  只使用不修改
 * 泛型下界  ？super A    只修改，不返回
 * 总结为PECS法则，Producer extends, Consumer super
 *
 *  kotlin ： "声明处型变"
 * * 频繁往外读取内容的，适合用上界Extends。 等同于 out  协变  out修饰符称为"型变注解"
 * * 经常往里插入的，适合用下界Super。  等同于 in  逆变
 *
 *
 *
 */
class Generics<out T>(val a :T) {

    fun getT() : T{
        return a
    }

}

fun main(args : Array<String>){

    testTemp(mutableListOf<SuperBasic>())
    println("hh")
    var m = arrayListOf<Basic>()
}

open class SuperBasic{

}

open class Basic : SuperBasic(){

}

class Son:Basic(){

}

fun testTemp(list : MutableList<in Basic>){
    var s : Any? = list.get(0)
    list.add(Basic())

}

//out类似java的
/***
class Te<T>{

    public T name;

    Te(T  a ){
        name = a;
    }

    public void add(T t){

    }
}
Te<? extends TextView> obj = new Te<Button>();

如果声明成extends上界，则不能obj.add(new Button())，编译器会报错，cannt be applied to  Te(Button）

*/


//java中多个上界的表示
/*
class  Monster <T extends Animal & Food>{

}
*/
//Kotlin中表示多个上界的方式
/*class Monster<T> where T: Animal, T:Food{

}*/

//reified只能用在inline函数上
inline fun <reified T> print(item : Any){
    if(item is T){

    }
}
