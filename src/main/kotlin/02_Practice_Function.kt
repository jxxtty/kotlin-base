// 파라미터 타입 : int, 리턴타입 : int
fun sum(a: Int, b: Int): Int { // int sum(int a, int b){return a+b;}
    return a+b;
}

// 리턴타입을 생략한 채 작성해도 된다.
fun sum2(a: Int, b: Int) = a+b

// 리턴타입이 없을때는 Unit을 쓰는데(java의 void같은 역할을 하는것같다)
fun printSum(a: Int, b: Int): Unit {
    println("sum :  $a + $b = ${a+b}")
}

// Unit은 생략해도 된다.
fun printSum2(a: Int, b: Int) {
    println("sum2 :  $a + $b = ${a+b}")
}

fun main(){
    println("call sum : " + sum(1,2))
    println("call sum2 : " + sum2(1, 2))
    print("call printSum -> ")
    printSum(3, 4)
    print("call printSum2 -> ")
    printSum2(3, 4)
}