fun main() {
    // kotlin에서 Array는 클래스다. 해당 클래스는 getter, setter를 갖고있고 size 프로퍼티또한 가지고있다.
    // get과 set은 인덱스연산자[]로 호출가능하다. 따라서 get set을 호출하지않고 []로 접근해서 사용하면 된다.

    // 배열 인스턴스는 arrayOf, arrayOfNulls, emptyArray 와 같은 표준 라이브러리 함수를 사용해서 만들 수 있다.

    // 1. arrayOf : 배열 선언과 동시에 값을 넣는다. 접근하는 방법은 자바와 동일하다
    var intArr = arrayOf(1, 2, 3, 4, 5);
    println("0 -> " + intArr[0]) // 1
    println("0 -> " + intArr.get(0)) // 1

    intArr[0] = 10
    println("0 -> " + intArr[0]) // 10
    intArr.set(0, 1234)
    println("0 -> " + intArr[0]) // 1234

    // 다차원 배열도 가능하다
    val array1 = arrayOf(1, 2, 3)
    val array2 = arrayOf(4, 5, 6)
    val array3 = arrayOf(7, 8, 9)

    val multiArr1 = arrayOf(array1, array2, array3)
    val multiArr2 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
    println("multiArr toString : ${multiArr1.contentDeepToString()}") // 2차원 배열 출력에는 contentDeepToString() 사용

}