fun main() {
    println("--------------------------------------------------")
    // 정렬(오름차순)을 할때는 sort, sorted 메소드를 사용한다.
    // 이 둘의 차이점은 원본Collection이 변경이되느냐 안되느냐의 차이다.
    // sort -> 원본 Collection 자체를 정렬하면서 변경시킨다.
    // sorted -> 원본 Collection은 그대로 둔 채 새로운 Collection에 정렬된 결과를 넣어서 반환한다.

    var ml = mutableListOf(5, 1, 3, 2, 6, 4)
    println("정렬 전 ml : $ml") // 정렬 전 ml : [5, 1, 3, 2, 6, 4]
    ml.sort()
    println("정렬 후 ml : $ml") // 정렬 후 ml : [1, 2, 3, 4, 5, 6] <- 원본 Collection 자체가 변경되었다.

    var ml2 = mutableListOf(5, 1, 3, 2, 6, 4)
    println("정렬 전 ml2 : $ml2") // 정렬 전 ml2 : [5, 1, 3, 2, 6, 4]
    var ml3 = ml2.sorted()
    println("정렬 후 ml2 : $ml2") // 정렬 후 ml2 : [5, 1, 3, 2, 6, 4] <- 원본 Collection은 변경되지 않았다.
    println("정렬 결과 ml3 : $ml3") // 정렬 결과 ml3 : [1, 2, 3, 4, 5, 6]



    println("--------------------------------------------------")
    // 내림차순 정렬을 할 땐 sortDescending, sortedDescending 메소드를 사용한다.
    var ml4 = mutableListOf(1, 3, 5, 6, 4, 2)
    println("내림차순 정렬 전 ml4 : $ml4") // 내림차순 정렬 전 ml4 : [1, 3, 5, 6, 4, 2]
    ml4.sortDescending()
    println("내림차순 정렬 후 ml4 : $ml4") // 내림차순 정렬 후 ml4 : [6, 5, 4, 3, 2, 1]

    var ml5 = mutableListOf(1, 3, 5, 6, 4, 2)
    println("내림차순 정렬 전 ml5 : $ml5") // 내림차순 정렬 전 ml5 : [1, 3, 5, 6, 4, 2]
    var ml6 = ml5.sortedDescending()
    println("내림차순 정렬 후 ml5 : $ml5") // 내림차순 정렬 후 ml5 : [1, 3, 5, 6, 4, 2]
    println("내림차순 정렬 결과 ml6 : $ml6") // 내림차순 정렬 결과 ml6 : [6, 5, 4, 3, 2, 1]



    println("--------------------------------------------------")
    // 특정한 값을 기준으로 정렬하기
    // sortBy, sortedBy, sortByDescending, sortedByDescending
    var ml7 = mutableListOf(2 to "abc", 4 to "abc", 3 to "qwe", 1 to "zwr")
    println("정렬 전 ml7 : $ml7") // 정렬 전 ml7 : [(2, abc), (4, abc), (3, qwe), (1, zwr)]
    ml7.sortByDescending { it.first }
    println("정렬 후 ml7 : $ml7") // 정렬 후 ml7 : [(4, abc), (3, qwe), (2, abc), (1, zwr)]


    println("--------------------------------------------------")
    // 여러가지 조건을 섞어서 정렬하기
    // sortWith, sortedWith
    var ml8 = mutableListOf(1 to "a", 2 to "b", 7 to "c", 6 to "d", 5 to "c", 6 to "e")
    println("정렬 전 ml8 : $ml8") // 정렬 전 ml8 : [(1, a), (2, b), (7, c), (6, d), (5, c), (6, e)]
    ml8.sortWith(
        compareBy({it.second}, {it.first}) // string(second)으로 정렬, string이 같다면 int(first)로 정렬한다
    )
    println("정렬 후 ml8 : $ml8") // 정렬 후 ml8 : [(1, a), (2, b), (5, c), (7, c), (6, d), (6, e)]

    ml8.sortWith(
        compareBy({it.second}, {-it.first})
    )
    println("내림차순으로 변경 : $ml8") // 내림차순으로 변경 : [(1, a), (2, b), (7, c), (5, c), (6, d), (6, e)]

    var ml9 = mutableListOf("1", "32", "23", "4", "5")
    var ml10 = ml9.sortedWith(
        Comparator{ a, b -> (b+a).compareTo(a+b)}
    )
    println("정렬 전 ml9 : $ml9") // 정렬 전 ml9 : [1, 32, 23, 4, 5]
    println("정렬 후 ml10 : $ml10") // 정렬 후 ml10 : [5, 4, 32, 23, 1]

    var ml11 = mutableListOf(2, 5, 3, 1, 4)
    var ml12 = ml11.sortedWith( Comparator { a, b -> b-a })
    println("정렬 전 ml11 : $ml11") // 정렬 전 ml11 : [2, 5, 3, 1, 4]
    println("정렬 후 ml12 : $ml12") // 정렬 후 ml12 : [5, 4, 3, 2, 1]
}