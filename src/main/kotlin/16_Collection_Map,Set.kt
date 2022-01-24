// Set -> 중복 허용X, 순서X
// 1. Set<out T> : 객체 추가, 삭제 불가능 -> setOf()로 생성
// 2. MutableSet<T>, HashSet<T>, LinkedHashSet<T>, TreeSet<T> : 객체 추가, 삭제 가능 -> mutableSetOf(), hashSetOf(), linkedSetOf(), treeSetOf()로 생성
// add(data), remove(data)

// Map
// 1. Map<K, out V> : 객체 추가, 삭제 불가능
// 2. MutableMap<K, V>, HashMap<K, V>, LinkedHashMap<K, V>, SortedMap<K, V> : 객체 추가, 삭제 가능 -> mutableMapOf(), hashMapOf(), linkedMapOf(), sortedMapOf()로 생성
// put(key, value), remove(key)

fun main() {
    val setTest = mutableSetOf("귤", "바나나", "키위")
    for(item in setTest) println("$item")

    // 객체 추가
    setTest.add("자몽")
    println(setTest) // [귤, 바나나, 키위, 자몽]
    setTest.add("자몽")
    println(setTest) // [귤, 바나나, 키위, 자몽] -> 중복을 허용하지 않는다("자몽"을 2번 넣었으나 한개만 넣어짐)

    // 객체 삭제
    setTest.remove("바나나")
    println(setTest) // [귤, 키위, 자몽]

    // 객체 존재 여부 확인
    println(setTest.contains("귤")) // true


    val mapTest = mutableMapOf("바나프레소" to "아이스아메리카노",
                                "스타벅스" to "돌체라떼",
                                "이디야" to "토피넛라떼")
    for(entry in mapTest){
        println("${entry.key} : ${entry.value}")
    }

    // 객체 추가
    mapTest.put("메가커피", "죠리퐁라떼")
    println(mapTest) // {바나프레소=아이스아메리카노, 스타벅스=돌체라떼, 이디야=토피넛라떼, 메가커피=죠리퐁라떼}

    // 객체 삭제
    mapTest.remove("이디야")
    println(mapTest) // {바나프레소=아이스아메리카노, 스타벅스=돌체라떼, 메가커피=죠리퐁라떼}

    // key값으로 value 가져오기
    println(mapTest["스타벅스"]) // 돌체라떼
}