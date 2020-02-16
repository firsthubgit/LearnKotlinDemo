package com.learn.kotlin.clazzobj


//顶层声明
//用作全局静态属性
val MY_TYPE_1 : String = "heihei"
//用作全局静态方法
fun test1(name : String) {
    println("test")
}

//可以用作单例，静态对象
object Constant{

    val MY_TYPE : String = "haha"

    fun test2(name : String) {
        println("test")
    }

}

class Test{
    //用在类内部，可以省略Constant。直接用Test.site访问
    companion object {
        var site : String = "www.baidu.com"
    }
}




fun main(){
    MY_TYPE_1
    test1("name")
    Constant.MY_TYPE
    Constant.test2("name2")
    test1(Test.site)
}