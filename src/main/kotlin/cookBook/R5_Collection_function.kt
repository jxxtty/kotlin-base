package cookBook

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    // [R5.1]
    val squares = Array(5){i -> (i * i).toString()}
    for(item in squares) print("$item ")
    println()

    println(squares[0])
    squares[0] = "1"
    println(squares[0])

    val indices = squares.indices
    println(indices)

    for((index, value) in squares.withIndex()) {
        println("Index $index maps to $value")
    }

    // [R5.2]
    val numMap = mapOf(1 to "one", 2 to "two")

    val list = LinkedList<Int>()
    list.add(33)
    list.add(11)
    list.addLast(999) // addLast의 별칭 -> add (add메소드 == addLast메소드)
    println(list) // [33, 11, 999]
    list[2] = 44
    list.addAll(listOf(1,2,3,4))
    println(list) // [33, 11, 44, 1, 2, 3, 4]

    // [R5.3]
    val mutableNums = mutableListOf(1, 2, 3, 4)
    val readOnlyNumList: List<Int> = mutableNums.toList()
    println(mutableNums == readOnlyNumList) // true
//    println(mutableNums.hashCode())
//    println(readOnlyNumList.hashCode())
    mutableNums.add(5)
    println(mutableNums == readOnlyNumList) // false
//    println(mutableNums.hashCode())
//    println(readOnlyNumList.hashCode())
    println(mutableNums) // [1, 2, 3, 4, 5]
    println(readOnlyNumList) // [1, 2, 3, 4]

    val readOnly: List<Int> = mutableNums
    println(mutableNums == readOnly) // true
//    println(mutableNums.hashCode())
//    println(readOnly.hashCode())
    mutableNums.add(6)
    println(mutableNums == readOnly) // true
//    println(mutableNums.hashCode())
//    println(readOnly.hashCode())
    println(mutableNums) // [1, 2, 3, 4, 5, 6]
    println(readOnly) // [1, 2, 3, 4, 5, 6]


    // R5.4
    val keys = 'a'..'f'
    val map = keys.associateWith { item ->
        item.toString().repeat(5)
        .replaceFirstChar { if (item.isLowerCase()) item.titlecase(Locale.getDefault()) else item.toString() }}
    val map2 = keys.associateWith { it.toString().repeat(3) }
    println(map) // {a=Aaaaa, b=Bbbbb, c=Ccccc, d=Ddddd, e=Eeeee, f=Fffff}
    println(map2) // {a=aaa, b=bbb, c=ccc, d=ddd, e=eee, f=fff}


    // R5.5
    val products: List<Product> = emptyList()
    println("빈 컬렉션을 넣으면 : ${namesOfProductsOnSale(products)}") // 빈 문자열로 리턴된다
    println("ifEmpty - Collection : ${namesOfProductsOnSaleIfEmptyCollection(products)}") // ifEmpty - Collection : none
    println("ifEmpty - String : ${namesOfProductsOnSaleIfEmptyString(products)}") // ifEmpty - String : none


    // R5.6
    val range = 3..8
    println(range.first) // 3
    println(range.last) // 8
    println(1.coerceIn(range)) // 3
    println(5.coerceIn(range)) // 5
    println(10.coerceIn(range))

    val min = 3
    val max = 8
    println(1.coerceIn(min, max)) // 3
    println(5.coerceIn(min, max)) // 5
    println(10.coerceIn(min, max)) // 8


    // R5.7
    val range2 = 0..10
    val chunked = range2.chunked(3)
    println(chunked) // [[0, 1, 2], [3, 4, 5], [6, 7, 8], [9, 10]] -> 리스트의 리스트 형태로 반환된다.

    // 변환 람다를 제공해 가공된 리스트로 반환
    println(range2.chunked(3){it.sum()}) // [3, 12, 21, 19]
    println(range2.chunked(3){it.average()}) // [1.0, 4.0, 7.0, 9.5]

    println(range2.windowed(3,3)) // range2.chunked(3) 과 동일 -> chunked는 인자로 들어온 3이라는 값을 windowed의 size와 step에 넣어서 호출한다.
    println(range2.windowed(3, 1)) // [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9], [8, 9, 10]]


    // R5.8
    val testList = listOf("a", "b", "c", "d", "e", "f", "g")
    val (a, b, c, d, e) = testList
    println("$a $b $c $d $e") // a b c d e

    val (aa, bb, cc, dd, ee) = testList
    println("$aa $bb $cc $dd $ee") // a b c d e


    // val (aa, bb, cc, dd, ee, ff, gg) = testList // 오류 -> component6(), component7() ~ 은 정의되어있지 않다.

    val testList2 = listOf("jxxtty", "github.com/jxxtty", "jxxtty.tistory.com")
    val (nickname, _ , blog) = testList2
    println("nickname : $nickname, blog : $blog") // nickname : jxxtty, blog : jxxtty.tistory.com
}

// R5.5
data class Product(val name: String, val price: Double, val onSale: Boolean = false)

fun namesOfProductsOnSale(products: List<Product>) = products.filter { it.onSale }.map { it.name }.joinToString(separator = ", ")
fun namesOfProductsOnSaleIfEmptyCollection(products: List<Product>) = products.filter { it.onSale }.map { it.name }.ifEmpty { listOf("none") }.joinToString(separator = ", ")
fun namesOfProductsOnSaleIfEmptyString(products: List<Product>) = products.filter { it.onSale }.map { it.name }.joinToString(separator = ", ").ifEmpty { "none" }
