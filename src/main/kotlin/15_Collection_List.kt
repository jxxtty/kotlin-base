// 리스트의 종류
// 1. List<T> : 생성시에 넣은 객체를 대체, 추가할 수 없음 -> listOf()로 생성
// 2. MutableList<T> : 생성시에 넣은 객체를 대체, 추가, 삭제할 수 있음 -> mutableListOf()로 생성

// 제공되는 함수
// 1. 요소의 추가 : add(data), add(index, data)
// 2. 요소의 삭제 : remove(data), removeAt(index)
// 3. 무작위 섞기 : shuffle()
// 4. 정렬 : sort()

fun main() {
    val a = listOf("사과", "딸기", "배")
    println(a[1]) // 배열과 사용방법이 똑같다


    for(fruit in a) { // 리스트 a에서 요소를 하나씩 꺼내 fruit에 할당해줌
        print("${fruit} ")
    }
    println()

    val b = mutableListOf(6, 3, 1)
    println(b) // [6, 3, 1]

    b.add(4)
    println(b) // [6, 3, 1, 4]

    b.add(2,8)
    println(b) // [6, 3, 8, 1, 4]

    b.removeAt(1)
    println(b) // [6, 8, 1, 4]

    b.shuffle()
    println(b) // [6, 1, 8, 4]

    b.sort()
    println(b) // [1, 4, 6, 8]
}