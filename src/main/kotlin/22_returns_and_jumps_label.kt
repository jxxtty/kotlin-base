// kotlin의 세가지 jump 표현식
// 1. return
// 2. break
// 3. continue

fun main() {

    // kotlin은 어떤 표현이든 label을 붙일 수 있다.
    // label을 붙일때는 '@'를 사용하는데, [라벨이름]@ 이런식으로 붙여주면 된다.
    println("label이 없는 loop - break")
    for(i in 1..3) {
        for(j in 1..5) {
            if(j == 4) break
            print("$j ")
        }
    }
    println("\n ----------------")

    println("label이 있는 loop - break")
    loop@ for(i in 1..3) {
        for(j in 1..5) {
            if(j == 4) break@loop
            print("$j ")
        }
    }
    println()

    // 결과
//    label이 없는 loop - break
//    1 2 3 1 2 3 1 2 3
//    ----------------
//    label이 있는 loop - break
//    1 2 3

    println("label이 없는 loop - continue")
    for(i in 1..3) {
        for(j in 1..5) {
            if(j == 4) continue
            print("$j ")
        }
    }

    println("\n ----------------")

    println("label이 있는 loop - continue")
    loop@ for(i in 1..3) {
        for(j in 1..5) {
            if(j == 4) continue@loop
            print("$j ")
        }
    }
    println()

    // 결과
//    label이 없는 loop - continue
//    1 2 3 5 1 2 3 5 1 2 3 5
//    ----------------
//    label이 있는 loop - break
//    1 2 3 1 2 3 1 2 3


    test() // 12
    println()
    test2() // 1245이것도 출력됩니다.
    test3() // 1245이것도 출력됩니다.


    var result = fooReturnLabelWithValue()
    println(result) // [number 1, number 2, three, number 4, number 5]
}


fun test() {
    listOf(1, 2, 3, 4, 5).forEach {
        if(it == 3) return // test 함수자체가 끝나버린다. - 가장 가까운 enclosing function(test)를 return 시켜준다.
        print(it)
    }
    println("이것도 출력됩니다.")
}

fun test2() {
    listOf(1, 2, 3, 4, 5).forEach test2@{
        if(it == 3) return@test2 // -> explicit label
        print(it)
    }
    println("이것도 출력됩니다.")
}

fun test3() {
    listOf(1, 2, 3, 4, 5).forEach {
        if(it == 3) return@forEach // forEach 자체를 label로 사용할 수도 있다. -> implicit label
        print(it)
    }
    println("이것도 출력됩니다.")
}


fun fooReturnLabelWithValue(): List<String> {
    var ints = listOf<Int>(1, 2, 3, 4, 5)
    return ints.map {
        if (it == 3) {
            return@map "three" // 원하는 값을 return시킬 수도 있다.
        }
        "number $it"
    }
}
