
// var -> variable = 읽기/쓰기가 가능한 일반 변수
// val -> valuable = 읽기만 가능한 final변수

fun main() {
    var readAndWrite: Int = 10
    readAndWrite = 11
    println(readAndWrite) // 11

    val onlyRead: Int = 10
    //onlyRead = 11 // -> 에러(쓰기가 불가능하다 -> 값 변경 불가능)

    val a: Int = 1
    val b = 2 // 타입 생략이 가능하다. -> 타입 추론가능

    val c:Int
    c = 456 // 선언과 동시에 초기화를 하지 않아도 괜찮다. 실제로 사용하기 전까지만 초기화해주면 된다.
    println(c) // 456

    // kotlin은 null을 허용하지 않는데, 만약 null을 허용하는 nullable변수를 선언하고 싶다면 '?'를 붙여주면 된다.
    // nullable 변수를 사용할 때 NPE가 발생될 수 있으니 꼭 필요할때만 사용하는 것이 좋다.
    var d:Int? = null
    println(d) // null

    // 숫자형(정수형 + 실수형)
    var intValue: Int = 1234
    var longValue: Long = 1234L
    var intValueByHex = 0x1af // 16진수
    var intValueByBin = 0b01101100 // 2진수
    var doubleValue: Double = 123.5
    var doubleValueWithExp: Double = 123.5e10 // 지수
    var floatValue: Float = 123.5f // f나 F 둘다 사용가능

    // 문자형
    var charValue: Char = 'a'
    var charValueKorean: Char = '가'

    // 논리형
    var booleanValue: Boolean = true

    // 문자열
    var stringValue = "one line"
    var multiStringValue = """multi
        line
        use
        three
        quotes
    """.trimMargin()
    println(multiStringValue)
}

