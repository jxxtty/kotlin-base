fun main() {
    // kotlin은 형변환시 발생할 수 있는 오류를 막기위해 "묵시적 형변환"은 지원하지 않는다.
    // "명시적 형변환"에는 toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()가 있다.
    // 논리형은 지원하지 않는다.

    var a:Int = 12345
    var b: Long = a.toLong()
    println("a is $a")
    println("b is $b")



    var c = a.toByte()
    var d = a.toDouble()
    println("c is $c") // 57d
    println("d is $d") // 12345.0


}