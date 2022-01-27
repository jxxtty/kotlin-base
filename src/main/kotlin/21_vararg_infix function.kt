fun main() {
    // vararg
    sum(1, 2, 3, 4)
    sum(123, 234, 789)


    // infix function
    println(6 multiply 4) // 24 -> dispatcher:6 , receiver:4
    println(6.multiply(3)) // 18

    val map = mapOf(Pair("key1", "value1"), Pair("key2", "value2"))
    val map2 = mapOf("key1" to "value1", "key2" to "value2") // to도 infix함수

    val myString = MyString()
    myString add "Hello"
    myString.add(" World") // <- add함수에서 infix 생략 시 이렇게만 호출가능하다
    myString add " Kotlin"
    println(myString.string) // Hello World Kotlin
}
// vararg
fun sum(vararg numbers: Int) {
    var sum = 0

    for(n in numbers) sum += n

    println(sum)
}

// infix function
// infix fun [dispatcher].[함수이름](receiver r): [리턴타입] { 구현부 }
infix fun Int.multiply(x: Int): Int = this * x // this : dispatcher

class MyString{
    var string = ""

    // 클래스 내에 infix function을 정의하는 경우 -> dispatcher가 자기 자신이기때문에 생략할 수 있다
    infix fun add(other: String){
        this.string = this.string + other
    }
}