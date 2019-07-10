```
Error: Kotlin: Suspend functions are only allowed to be called from a coroutine or another suspend function
```

这是因为 [delay] 是一个特殊的 _挂起函数_ ，它不会造成线程阻塞，但是会 _挂起_
协程，并且只能在协程中使用。

### 桥接阻塞与非阻塞的世界

第一个示例在同一段代码中混用了 _非阻塞的_ `delay(……)` 与 _阻塞的_ `Thread.sleep(……)`。
这容易让我们记混哪个是阻塞的、哪个是非阻塞的。
让我们显式使用 [runBlocking] 协程构建器来阻塞：


```
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch { // 在后台启动一个新的协程并继续
        delay(1000L)
        println("World!")
    }
    println("Hello,") // 主线程中的代码会立即执行
    runBlocking {     // 但是这个表达式阻塞了主线程
        delay(2000L)  // ……我们延迟 2 秒来保证 JVM 的存活
    } 
}
```

> 可以在[这里](../kotlinx-coroutines-core/jvm/test/guide/example-basic-02.kt)获取完整代码。

<!--- TEST
Hello,
World!
-->
