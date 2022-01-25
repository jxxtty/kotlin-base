fun main() {
    var test = "Test.Kotlin.String"

    // 1. 길이 - length
    println(test.length) // 18

    // 2. 대문자, 소문자 - uppercase(), lowercase()
    println(test.uppercase()) // TEST.KOTLIN.STRING
    println(test.lowercase()) // test.kotlin.string

    // 3. 특정문자를 기준으로 끊어서 배열만들기 - split()
    var test2 = test.split(".")
    println(test2) // [Test, Kotlin, String]

    // 4. 배열 합치기 - joinToString()
    println(test2.joinToString()) // Test, Kotlin, String
    println(test2.joinToString("-")) // Test-Kotlin-String

    // 5. 문자열 자르기 - substring()
    println(test.substring(5..10)) // Kotlin



    // 6. 문자열이 비어있는지 확인하기 - isNullOrEmpty(), isNullOrBlank()
    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    println(nullString.isNullOrEmpty()) // true
    println(emptyString.isNullOrEmpty()) // true
    println(blankString.isNullOrEmpty()) // false
    println(normalString.isNullOrEmpty()) // false

    println(nullString.isNullOrBlank()) // true
    println(emptyString.isNullOrBlank()) // true
    println(blankString.isNullOrBlank()) // true -> 공백문자까지 체크해준다.(공백문자 : space, tab, line feed, carriage return, + 눈에 보이지 않는 공백 문자)
    println(normalString.isNullOrBlank()) // false



    // 7. ~로 시작하는 문자열, ~로 끝나는 문자열 - startsWith(), endsWith()
    var test3 = "kotlin.jxxtty.kt"
    var test4 = "java.jxxtty.java"
    println(test3.startsWith("java")) // false
    println(test4.startsWith("java")) // true

    println(test3.endsWith(".kt")) // true
    println(test4.endsWith(".kt")) // false

    // 8. 문자열에 특정 문자열이 포함되는지의 여부
    println(test3.contains("lin")) // true
    println(test4.contains("lin")) // false



    // 9. 특정 index
    var test5 = "hello kotlin, hello jxxtty"
    println(test5[0]) // h

    // 10. 특정 문자의 index값 반환
    println(test5.indexOf('h')) // 0

    // 11. 특정 문자A를 특정 문자B로 대체
    println(test5.replace(' ', '+')) // hello+kotlin,+hello+jxxtty
    println(test5.replace("h", "x")) // xello kotlin, xello jxxtty



    // 12. 문자열 합치기 - buildString { append(), appendLine() }
    // 자바에서는 StringBuilder 를 이용했다면, 코틀린에서는 정의되어있는 인라인 함수에 함수호출로 사용할 수 있다.
    // inline fun buildString(
    //    builderAction: StringBuilder.() -> Unit
    // ): String
    val countDown = buildString {
        for(i in 5 downTo 1){
            append(i)
            appendLine()
        }
    }
    println(countDown)
    // 5
    // 4
    // 3
    // 2
    // 1



    // 13. 문자열을 둘러싸고있는 특정문자 제거하기(맨앞, 맨뒤) - removeSurrounding()
    var input = "##place##holder##"
    println(input.removeSurrounding("##")) // place##holder



}