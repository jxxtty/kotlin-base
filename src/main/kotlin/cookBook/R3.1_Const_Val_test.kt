package cookBook

// 'val' 과 'const val' 의 차이
//const val constVal = sumExam(10, 20) // 오류발생
val number = sumExam(10, 20)
fun main() {

    println(number)

    val myArray = arrayListOf("java")
    println(myArray) // [java]

    myArray.add("kotlin")
    println(myArray) // [java, kotlin]

    val secondArray = arrayListOf("hello", "hi")
    //myArray = secondArray // 오류발생

}

fun sumExam(a: Int, b: Int) = a + b