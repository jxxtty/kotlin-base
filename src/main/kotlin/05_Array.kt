fun main() {
    // kotlin에서 Array는 클래스다. 해당 클래스는 getter, setter를 갖고있고 size 프로퍼티또한 가지고있다.
    // get과 set은 인덱스연산자[]로 호출가능하다. 따라서 get set을 호출하지않고 []로 접근해서 사용하면 된다.

    // 배열 인스턴스는 arrayOf, arrayOfNulls, emptyArray 와 같은 표준 라이브러리 함수를 사용해서 만들 수 있다.
    // Boxing overhead 없이 기본유형의 배열을 표현하기 위한 전문 클래스도 사용가능하다 -> ByteArray, ShortArray, IntArray
    //      이 클래스들은 Array클래스와 상속 관계가 없지만 동일한 메서드 및 프로퍼티 집합을 가진다. 각 클래스는 그에 맞는 "팩토리 함수"를 가지고 있다. 이 팩토리 메소드로 배열 생성이 가능하다.

    // 1. arrayOf : 배열 선언과 동시에 값을 넣는다. 접근하는 방법은 자바와 동일하다
    var intArr = arrayOf(1, 2, 3, 4, 5);
    println("0 -> " + intArr[0]) // 1
    println("0 -> " + intArr.get(0)) // 1

    intArr[0] = 10
    println("0 -> " + intArr[0]) // 10
    intArr.set(0, 1234)
    println("0 -> " + intArr[0]) // 1234

    // 2. arrayOfNulls
    var nullArr = arrayOfNulls<Int>(3)
    println("is Null? : " + nullArr[0] + " " + nullArr[1] + " " + nullArr[2]) // null null null
    nullArr[0] = 1
    println("is Null? : " + nullArr[0] + " " + nullArr[1] + " " + nullArr[2]) // 1 null null

    // 3. emptyArray
    var emptyArr = emptyArray<Int>();
    println(emptyArr.size)

    // 4. IntArray 같이 명시적으로 사용
    var testArr = intArrayOf(1, 2, 3)
    println("-> " + testArr[0] + " " + testArr[1] +" " + testArr[2]) // 1 2 3

    // 5. 표현식을 통한 배열 생성
    var testArr2 = Array(5, {i -> i*2})
    println("-> " + testArr2[0] + " " + testArr2[1] + " " + testArr2[2] + " " + testArr2[3] + " " + testArr2[4]) // 0 2 4 6 8


    // 다차원 배열도 가능하다
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)
    val array3 = arrayOf(7, 8, 9)

    val multiArr1 = arrayOf(array1, array2, array3)
    val multiArr2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
    println("multiArr toString : ${multiArr1.contentDeepToString()}") // 2차원 배열 출력에는 contentDeepToString() 사용


    // Any로 선언한 배열에는 다른 자료형을 저장할 수 있다.
    val anyArr = Array<Any>(10, {0}) // 10짜리, 0으로 초기화된 배열
    anyArr[0] = "Hello"
    anyArr[1] = 1.1
    anyArr[2] = true
    anyArr[3] = 'c'
    println("anyArr : " + anyArr[0] + " " + anyArr[1] + " " + anyArr[2] + " " + anyArr[3] + " " + anyArr[4]) // Hello 1.1 true 0


    // 멤버 메소드를 통한 배열 순환
    var arrPractice = intArrayOf(1, 2, 3, 4, 5)
    arrPractice.forEach { element -> print("$element ") } // forEach() : 요소 개수 만큼 지정한 구문을 반복 실행
    println()
    arrPractice.forEachIndexed {i, e -> println("arr[$i] = $e")} // forEachIndexed : 순환하며 인덱스까지 출력한다. 인덱스는 i, 요소는 e로 받아 인덱스와 함께 요소를 출력한다.

    val iterator = arrPractice.iterator() // val iterator: Iterator<Int> = arrPractice.iterator()
    while (iterator.hasNext()) {
        val e = iterator.next()
        print("$e ")
    }

}