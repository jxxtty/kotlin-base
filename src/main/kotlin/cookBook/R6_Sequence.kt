package cookBook

import kotlin.math.ceil
import kotlin.math.sqrt
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main() {
    var result: Int

    val time = measureTimedValue {
        result = (100 until 2000000).map{ it * 2 }
            .filter{ it % 3 == 0}
            .first()
    }

    val time2 = measureTimedValue {
        result = (100 until 2000000).map { it * 2 }
            .first{ it % 3 == 0}
    }

    val time3 = measureTimedValue {
        result = (100 until 2000000).asSequence()
            .map { println("doubling! : $it"); it * 2 }
            .filter { println("filtering! : $it"); it % 3 == 0}
            .first()
    }
//    doubling! : 100
//    filtering! : 200
//    doubling! : 101
//    filtering! : 202
//    doubling! : 102
//    filtering! : 204


    println("결과값 : $result, 실행시간 : ${time.duration}")
    println("결과값 : $result, 실행시간 : ${time2.duration}")
    println("결과값 : $result, 실행시간 : ${time3.duration}")

    println(nextPrime(6))

    println(nextPrime(182))
}
fun Int.isPrime() =
    this == 2 || (2..ceil(sqrt(this.toDouble())).toInt()).none{ divisor -> this % divisor == 0}

fun nextPrime(num: Int) = generateSequence(num + 1) { it + 1 }.first(Int::isPrime)