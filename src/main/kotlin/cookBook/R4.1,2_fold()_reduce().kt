package cookBook

import sum
import java.math.BigInteger

fun sumWithTrace(vararg nums: Int) =
    nums.fold(0) { acc, n ->
        println("acc = $acc, n = $n")
        acc + n
    }

fun recursiveFactorial(n: Long): BigInteger =
    when(n) {
        0L, 1L -> BigInteger.ONE
        else -> BigInteger.valueOf(n) * recursiveFactorial(n-1)
    }.also { println("현재 n : $n") }

fun factorialFold(n: Long): BigInteger =
    when(n) {
        0L, 1L -> BigInteger.ONE
        else -> (2..n).fold(BigInteger.ONE) { acc, i -> acc * BigInteger.valueOf(i)}
    }

fun sumReduce(vararg nums: Int) = nums.reduce{acc, i -> acc+i}

fun main(){

    // fold(누적자의 초기값){누적자, 배열에서 꺼내오는 값 ->  }
    var intArray = intArrayOf(1, 2, 3)
    var foldValue = intArray.fold(0){acc, num -> acc+num}
    println(foldValue) // 6

    var intArray2 = emptyArray<Int>()
    var foldValue2 = intArray2.fold(0){acc, num -> acc+num}
    println(foldValue2) // 0

    println(sumWithTrace(1, 2, 3))
//    acc = 0, n = 1
//    acc = 1, n = 2
//    acc = 3, n = 3
//    6

    println(BigInteger.valueOf(5))

    println(recursiveFactorial(4)) // 24
    println(factorialFold(4)) // 24


    var reduceValue = sumReduce(1, 2, 3)
    println(reduceValue) // 6

    println(intArray2.reduce{acc, i -> acc + i}) // exception발생 - Empty array can't be reduced.
}