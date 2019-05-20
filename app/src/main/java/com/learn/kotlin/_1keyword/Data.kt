package com.learn.kotlin._1keyword

import java.io.Serializable


/**
 * 数据类 标记为 data
 *
 * data class User(val name: String, val age: Int)
 *
 * 编译器自动从主构造函数中声明的所有属性导出以下成员：
        equals()/hashCode() 对；
        toString() 格式是 "User(name=John, age=42)"；
        componentN() 函数 按声明顺序对应于所有属性；
        copy() 函数（见下文）。

 * 必须符合如下要求：
        主构造函数需要至少有一个参数；
        主构造函数的所有参数需要标记为 val 或 var；
        数据类不能是抽象、开放、密封或者内部的；
        （在1.1之前）数据类只能实现接口。
 * */

data class WeatherData(
    val query: Query
) : Serializable

data class Query(
    val count: Int,
    val created: String,
    val lang: String,
    val results: Results
) : Serializable

data class Results(
    val channel: Channel
) : Serializable

data class Channel(
    val title: String,
    val link: String,
    val description: String,
    val language: String,
    val lastBuildDate: String,
    val ttl: String
) : Serializable
