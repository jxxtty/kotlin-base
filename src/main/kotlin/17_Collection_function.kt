// Collecion function(컬렉션 함수)
// list, set, map과 같은 컬렉션 또는 배열에 일반 함수, 람다함수 형태를 사용하여 for문 없이도 아이템을 순회하며 참조하거나 조건을 걸고, 구조의 변경까지 가능한 여러 함수를 지칭한다
// 코틀린은 함수형 언어의 특징을 갖고있기 때문에 좀 더 편리하게 컬렉션을 사용할 수 있다.

fun main() {
    val nameList = listOf("재롱이", "달리", "행크", "우유", "모카", "구월이")

    // 컬렉션에 포함된 모든 객체들을 it으로 참조할 수 있다.

    // 1. forEach
    nameList.forEach{ print("$it ") }
    println() // 재롱이 달리 행크 우유 모카 구월이



    // 2. filter
    // 중괄호 안에 조건을 걸어주면, 조건에 맞는 객체들만 걸러서 새로운 컬렉션으로 반환한다
    println(nameList.filter{ it.contains("이") }) // [재롱이, 구월이]



    // 3. map
    // 중괄호안에 수식 또는 연산을 적용하면, 변경된 객체들로 구성된 새로운 컬렉션으로 반환한다
    println(nameList.map { "갱얼쥐 :  $it" }) // [갱얼쥐 :  재롱이, 갱얼쥐 :  달리, 갱얼쥐 :  행크, 갱얼쥐 :  우유, 갱얼쥐 :  모카, 갱얼쥐 :  구월이]



    // 4. any, all, none
    // any : 하나라도 조건에 맞으면 true
    // all : 모두 조건에 맞으면 true
    // none : 하나도 조건에 맞지 않으면 true
    println(nameList.any{ it == "달리" }) // true
    println(nameList.all{ it.length == 3 }) // false
    println(nameList.all{ it.length > 1 }) // true
    println(nameList.none{ it.length == 1 }) // true



    // 5. first
    // - collection.first() : 컬렉션의 첫번째 아이템을 반환
    // - collection.first{ 조건 } : 조건에 맞는 첫번째 아이템을 반환
    println(nameList.first()) // 재롱이
    println(nameList.first{ it.length == 2 }) // 달리



    // 6. last
    // - collection.last() : 컬렉션의 마지막 아이템을 반환
    // - collection.last{ 조건 } : 조건에 맞는 마지막 아이템을 반환
    println(nameList.last()) // 구월이
    println(nameList.last{ it.length == 2 }) // 모카



    // 7. count
    // - collection.count() : 컬렉션의 모든 아이템 개수를 반환
    // - collection.count{ 조건 } : 조건에 맞는 아이템의 개수를 반환
    println(nameList.count()) // 6
    println(nameList.count{ it.contains("이") }) // 2

    // --------------------------------------------------------

    var childList = listOf(Child("시아", 2003), Child("유나", 2001), Child("하은", 2003))

    // 8. associateBy
    // 중괄호안에 key로 사용할 값을 지정, 아이템에서 key를 추출하여 map으로 변환하는 함수
    var childMap = childList.associateBy { it.name }
    childMap.forEach {
        println("${it.key} : ${it.value}")
    }
//    시아 : Child(name=시아, birthYear=2003)
//    유나 : Child(name=유나, birthYear=2001)
//    하은 : Child(name=하은, birthYear=2002)



    // 9. groupBy
    // 중괄호 안에 key를 지정, key가 같은 아이템끼리 "배열"로 묶어 map으로 변환하는 함수
    var childMap2 = childList.groupBy { it.birthYear }
    childMap2.forEach {
        println("${it.key} : ${it.value}")
    }
//    2003 : [Child(name=시아, birthYear=2003), Child(name=하은, birthYear=2003)]
//    2001 : [Child(name=유나, birthYear=2001)]



    // 10. partition
    // 중괄호 안에 조건을 작성, 조건에 대하여 참과 거짓을 나눠 두개의 컬렉션을 각각 만들고 해당 컬렉션들을 담은 Pair를 반환한다
    // Pair : 두개의 객체를 담을 수 있다, first second로 접근할 수 있다
    var childPair = childList.partition { it.birthYear > 2002 }
    println("2002 true : ${childPair.first}") // 2002 true : [Child(name=시아, birthYear=2003), Child(name=하은, birthYear=2003)]
    println("2002 false : ${childPair.second}") // 2002 false : [Child(name=유나, birthYear=2001)]
    // 각각(두 개의 컬렉션)을 변수로 받을 수도 있다.
    var (over2002, under2002) = childList.partition { it.birthYear > 2002 }
    println(over2002) // [Child(name=시아, birthYear=2003), Child(name=하은, birthYear=2003)]
    println(under2002) // [Child(name=유나, birthYear=2001)]



    // 11. flatMap
    // collection 내부에 collection이 들어있는 경우, 내부의 collection들을 펼쳐주는 연산. 중괄호에는 내부의 collection 중에 어떤것을 취할것인지 조건을 지정한다
    // 아이템마다 만들어지는 컬렉션을 하나로 합쳐서 반환한다
    var testList = listOf(listOf(1, 2), listOf(7, 8, 9), mutableListOf(4, 5, 6))
    println(testList.flatMap { it }) // [1, 2, 7, 8, 9, 4, 5, 6]
    println(testList.flatMap { it.take(1) }) // [1, 7, 4] -> 내부 collection에서 첫번째 값들

    var testList2 = listOf(-3, 7, 2, -10, 1)
    println(testList2.flatMap { listOf(it*10, it+10) }) // [-30, 7, 70, 17, 20, 12, -100, 0, 10, 11]



    // 12. getOrElse
    // getOrElse(인덱스){기본값}
    // 인덱스 위치에 아이템이 있으면 아이템을 반환하고, 아니라면 지정한 기본값을 반환한다
    println(testList2.getOrElse(1){50}) // 7 (testList2[1])
    println(testList2.getOrElse(10){50}) // 50 (기본값)



    // 13. zip
    // 컬렉션 두개의 아이템을 1:1 매칭하여 새로운 컬렉션을 만든다.
    // 1:1 매칭 -> Pair, 새로운 컬렉션으로 반환 -> List<Pair>
    // 새로운 컬렉션으로 반환되는 크기는 두 개의 아이템 중 작은 값을 따라간다
    val alphaList = listOf("A", "B", "C", "D")
    println(alphaList zip testList2) // [(A, -3), (B, 7), (C, 2), (D, -10)]

}

data class Child(var name: String, var birthYear: Int)