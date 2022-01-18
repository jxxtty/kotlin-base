// Kotlin에서 반복문은 in 연산자를 사용하여 처리한다.
// index로 사용하는 변수에는 var이나 val을 붙이지 않아도 된다.

fun main() {
    // 1. 기본 in연산자 활용하여 배열을 반복문으로 출력
    val arr = intArrayOf(1, 2, 3)
    for (item in arr) {
        println(item)
    }

    // 2. 인덱스 값을 받아와 사용하고자 한다면 indices를 활용
    // 여기서 indices는 IntRange 타입이다.
    val arr2 = arrayOf("하나", "둘", "셋")
    for(index in arr2.indices) print(index) // 0 1 2
    println()
    for(index in arr2.indices) print(arr2[index] + " ")
    println()

    // 3. 범위를 지정하는 방법에는 여러가지가 있다.
    // 기본적으로 증가, 감소가 1씩 이뤄지고, 증가감소의 값을 변경하고 싶다면 step을 사용한다.
    // 증가의 경우 범위를 ..으로 사용하고, 감소의 경우 범위를 downTo로 사용한다.
    for(i in 0..9) print(i)
    println()
    for(i in 0..9 step 3) print(i) // 0369 -> 3씩 증가
    println()
    for (i in 9 downTo 0) print(i) // 9876543210 -> 1씩 감소
    println()
    for(i in 'a'..'e') print(i) // abcde
    println()
    for(i in 'e' downTo 'a') print(i) // edcba
    println()
    for(i in 1 until 10) print(i) // 123456789 -> 1씩증가, 10은 제외
    println()
    for(i in 9 downTo 1 step 2) print(i) // 97531 -> 2씩 감소
    println()


    // 4. while, do-while은 자바와 사용이 동일하다.
    var a = 0;

    while(a < 5){
        print(a++) // 01234
    }
    println()
    a = 0;
    do {
        print(a++) // 01234
    }while(a<5)
}