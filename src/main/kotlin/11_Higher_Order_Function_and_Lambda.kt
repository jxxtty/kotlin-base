// 고차함수 : 함수를 매개변수로 받을 수 있고 또 반환도 할 수 있는 함수, 자바에서의 콜백함수와 같다
// 고차함수에 전달되는 함수(또는 코드 조각)를 람다(Lambda)라고 한다.
// 람다식은 "{인자1: 타입, 인자2: 타입, .. -> 반환식}"의 형식을 갖는다. 경우에 따라 간략하게 줄여쓸 수도 있다.

fun a (str: String) {
    println("$str 함수 a")
}

fun b (sendA: (String) -> Unit){ // (파라미터) -> 반환형
    sendA("b가 호출한")
}

// calculator는 고차함수다(파라미터로 함수를 받고있다)
fun calculator(x: Int, y: Int, func: (Int, Int) -> Int){ // 람다식의 형식( (Int,Int) -> Int )을 만드시 명시해줘야한다.
    println("$x, $y -> ${func(x,y)}")
}
fun minus(a: Int, b: Int) = a - b

// 람다식의 인자가 하나인 경우
fun square(a: Int, func: (Int) -> Int){
    println("square $a -> ${func(a)}")
}

// 람다식의 반환값이 없는 경우
fun printInfo(func: () -> Unit){
    print("Calculator version : ")
    func()
}

// 람다식을 nullable로 지정할 수 있다.
fun printInfo2(func: (() -> Unit)? = null){
    print("Calculator version : ")
    func?.invoke()?: println("no version") // invoke() 는 매개변수에 따라 함수를 호출하는 메서드
}

fun main() {
    // main함수가 a함수를 b함수에 파라미터로 넘겨준다.
    // ::(더블콜론) 은 '리플렉션'을 위해 사용한다
    // 리플렉션 이란, 런타임상 컴파일된 바이트 코드에서 내가 작성한 코드가 어디에 위치하는지 알 수 없기 때문에 바이트 코드를 이용해 내가 참조하려는 값을 찾기위해 사용한다.
    b(::a) // b가 호출한 함수 a

    // kotlin은 함수형 프로그래밍을 지원한다. 이는 '함수'자체를 값으로 취급하기 때문에 변수로 저장하거나, 매개변수로 전달하는 것이 가능하다.
    val sum = {x: Int, y: Int -> x + y} // 타입 추론
    // val sum: (Int, Int) -> Int = {x, y -> x+y}
    println(sum(2,3)) // 5


    calculator(2, 1, {x: Int, y: Int -> x + y}) // 2, 1 -> 3
    // lambda함수가 파라미터 중 제일 마지막에 있다면 밖으로 뺄 수 있다.
    calculator(3, 5) {x: Int, y: Int -> x + y} // 3, 5 -> 8
    // 또, 고차함수에 이미 타입이 정의되어있기 때문에 타입을 생략할 수도 있다.
    calculator(4, 6) {x, y -> x + y} // 4, 6 -> 10
    // 위에서 정의한 sum과 동일한 역할을 하여, 람다식을 넣는대신 sum을 넣어줄 수도 있다.
    calculator(3, 4, sum) // 3, 4 -> 7
    // 위에서 정의한 minus 함수를 넣어줄 때는 ::연산자를 사용한다.
    calculator(5, 1, ::minus) // 5, 1 -> 4


    // 람다식의 인자가 하나인 경우 -> 'it'을 사용해서 더 간단하게 표현이 가능하다
    square(3) { a -> a * a} // square 3 -> 9
    square(4) { it * it } // square 4 -> 16



    // 람다식의 반환값이 없는 경우
    printInfo() { println("1.0") } // Calculator version : 1.0
    // 고차함수의 인자가 람다식 1개인 경우 ()를 생략할 수 있다.
    printInfo { println("1.1") } // Calculator version : 1.1


    // 람다식이 null인 경우
    printInfo2() // Calculator version : no version


}
