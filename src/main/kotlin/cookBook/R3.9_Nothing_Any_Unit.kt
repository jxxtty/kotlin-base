package cookBook

fun unitTest(): Unit{
    print("call unitTest : ")
}
fun unitTest2(): Unit{
    print("call unitTest2 - first : ")
    return
    println("call unitTest2 - second")
}
fun unitTest3(): Unit{
    print("call unitTest3 - first : ")
    return Unit
    println("call unitTest3 - second")
}

fun doNothing(): Nothing = throw Exception("hi hello~")

fun main(){
    println(unitTest().hashCode())
    println(unitTest2().hashCode())
    println(unitTest3().hashCode())

    doNothing()
}