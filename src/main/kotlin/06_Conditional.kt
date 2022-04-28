import java.time.DayOfWeek

// 조건문을 사용하는 방법은 자바와 동일하다(if, else)
// Kotlin에서 지원하는 조건문 중 "다중조건문 When"에 대해서 간단하게만 알아보겠다.

// java 에서 지원하는 switch문이 코틀린에는 없다. 대신 다중 조건문 When을 지원한다.
// 하나의 변수를 여러개의 값과 비교할 수 있다. 단, 등호나 부등호의 사용이 불가능하다.
// 여러 조건에 부합하더라도 먼저 부합하는 조건이 실행된다.
// 주의할 점은 코틀린 컴파일러는 when이 표현식으로 사용될 때 else부분이 존재하는지, 표현식이 가능한 모든 입력에 대해 값을 생성하는 지를 검증한다. else가 없거나 처리할 수 없는 입력케이스가 있다면 컴파일러는 오류를 발생시킨다.
// else는 기본 선택지를 담당한다. else는 위에 설정된 모든 조건에 해당하지 않을 경우에 해당하며, 컴파일러는 else가 있는지를 강력하게 확인한다. 또한 else가 마지막이 아닌 부분에 오는 것은 허용하지 않는다.

// 1. when을 표현식으로 사용
fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "TuesDay", "Wednesday", "Thursday") -> "Work Hard"
    in 2..4 -> "Work Hard" // 전달받은 파라미터(dayOfWeek)가 리스트의 범위에 속하는지를 각각 확인
    "Friday" -> "Party"
    is String -> "What"
    else -> "No Clue"
}


// 2. when을 명령문으로 사용
// 리턴타입이 Unit이다. 즉, 함수는 아무것도 리턴하지 않고 when 안에서 각각의 조건별로 프린트한다.
// 코틀린에서 when이 명령문으로 사용될 때는 else가 없어도 상관없다.
fun doWhen(a: Any) {
    when (a) {
        1 -> println("1입니다.")
        "jxxtty" -> println("jxxtty입니다.")
        is Long -> println("Long 타입 입니다.")
        !is String -> println("String 타입이 아닙니다.")
        else -> println("어떤 조건도 만족하지 않습니다.")
    }
}

// 변수가 when의 스코프에서만 사용된다면 when으로 변수의 스코프에 제약을 주는 것이 좋다. -> 변수가 새어나가서 다르게 사용되는 것을 방지할 수 있고 코드를 관리하기 쉽게 만들어준다.
// 리팩토링 전
fun systemInfo(): String {
    val numberOfCores = Runtime.getRuntime().availableProcessors();
    return when (numberOfCores) {
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want your machine"
    }
}
// 리팩토링 후
// 장점 1. when의 결과를 바로 리턴하여 바깥쪽 블럭{}과 return키워드를 제거해 덜 복잡한 코드를 만들 수 있다.
// 장점 2. numberOfCores는 when의 결과를 얻을 때만 사용이 가능하고, 이후의 연산에서는 사용이 불가능하다. -> 변수의 스코프를 when으로 제한
fun systemInfoRefac(): String =
    when (val numberOfCores = Runtime.getRuntime().availableProcessors()) {
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want your machine"
    }


fun testWhenWithoutArgument(str: String): String {
    return when {
        str == "hello" -> "hi hello"
        else -> "else else"
    }
}

fun main() {
    println(whatToDo("Sunday")) // Relax
    println(whatToDo("Wednesday")) // Work Hard
    println(whatToDo(3)) // Work Hard
    println(whatToDo("Friday")) // Party
    println(whatToDo("MMonday")) // What
    println(whatToDo(8)) // No Clue

    doWhen(1)
    doWhen("jxxtty")
    doWhen(12L)
    doWhen(3.141592)
    doWhen("Kotlin")

    println(systemInfo())
    println(systemInfoRefac())

    println("withoutArgument : ${testWhenWithoutArgument("hello")}") // withoutArgument : hi hello
    println("withoutArgument : ${testWhenWithoutArgument("h")}") // withoutArgument : else else
}