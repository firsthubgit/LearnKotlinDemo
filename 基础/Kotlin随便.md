
for循环的几种  
or 循环可以对任何提供迭代器（iterator）的对象进行遍历

```kotlin
val array = listOf("apple", "banana", "kiwi")

//通过索引遍历一个数组或者一个 list
for (i in array.indices) {
    print(array[i])
}
//或者
for ((index, value) in array.withIndex()) {
    println("the element at $index is $value")
}

for (index in array.indices) {
        println("item at $index is ${items[index]}")
    }

```