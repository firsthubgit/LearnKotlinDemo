**目录**   

* [字符串拼接](#字符串拼接)
* [原始类型 Primitive](#原始类型-primitive)





查看字节码方式：Tools --> Kotlin --> Show Kotlin ByteCode


# 字符串拼接

Java中字符串的拼接推荐使用StringBuilder  

Kotlin中 
```kotlin
fun stringAdd(){
    var string = ""
    for(i in 9_999){
        string += "kotlin"
    }
} 

```
对应的字节码
``` 
L2
 ILOAD 1
 ILOAD 2
 IF_ICMPGT L3
L4
 LINENUMBER 7 L4
 ALOAD 0
 NEW java/lang/StringBuilder
 DUP
 INVOKESPECIAL java/lang/StringBuilder.<init> ()V
 SWAP
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 LDC "kotlin"
 INVOKEVIRTUAL java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
 INVOKEVIRTUAL java/lang/StringBuilder.toString ()Ljava/lang/String;
 ASTORE 0
L5
 LINENUMBER 6 L5
 IINC 1 1
L6
 GOTO L2
```
可见循环内每次都创建StringBuilder，所以应该修改 
```kotlin
fun stringAdd(){
    val stringBuilder = StringBuilder()
    for(i in 0..9_999){
        stringBuilder.append("kotlin")
    }
}
```

# 原始类型 Primitive

