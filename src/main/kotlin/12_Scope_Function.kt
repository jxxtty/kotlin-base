// 스코프 함수 : 함수형 언어의 특징을 좀 더 편리하게 사용할 수 있도록 코틀린에서 기본으로 제공하는 함수
// 클래스의 인스턴스를 스코프 함수에 전달하면 인스턴스의 속성이나 함수를 스코프 함수 내에서 편하게 사용할 수 있다.
// 스코프함수는 람다식으로 호출할 때 임시로 범위(Scope)를 만든다. 이 범위 내에서는 객체의 이름이 없어도 객체에 접근할 수 있다.
// 종류 -> let, run, with, apply, also

class Book(var name: String, var price: Int){
    fun discount() {
        price -= 2000
    }
}

fun main() {
    // 1. apply
    // 인스턴스를 생성한 후에 변수에 담기기 전에 초기화 과정을 수행할 때 사용한다.
    // 생성되자마자 조작된 인스턴스를 변수에 바로 넣어줄 수 있다.
    var book1 = Book("코틀린 쿡북1", 30000)
    book1.name = "[초특가] " + book1.name
    book1.discount()

    var book2 = Book("코틀린 쿡북2", 30000).apply {
        name = "[초특가] " + name
        discount()
    }

    // 2. run
    // 일반 람다함수 처럼 인스턴스 대신 마지막 구문에 결과값을 반환한다
    book2.run {
        println("run 상품명 : $name, 가격 : $price")
    } // run 상품명 : [초특가] 코틀린 쿡북2, 가격 : 28000

    // 3. with
    // run과 동일한 기능을 갖지만, 단지 인스턴스를 참조연산자 대신 파라미터로 받는다는 차이가 있다.
    with(book2){
        println("with 상품명 : $name, 가격 : $price")
    } // with 상품명 : [초특가] 코틀린 쿡북2, 가격 : 28000


    // apply, run이 참조연산자 없이 인스턴스의 변수와 함수를 사용할 수 있었다면 also, let은 마치 파라미터로 인스턴스를 넘긴 것처럼 'it'을 통해서 인스턴스를 사용할 수 있다.
    // 왜 이렇게 사용하냐면, 같은 이름의 변수나 함수가 스코프 바깥에 중복되어 있는 경우에 혼란을 방지하기 위해서다.
    // 4. let
    // 처리가 끝나면 최종값을 반환한다.
    var price = 5000
    book2.let {
        println("let 상품명 : ${it.name}, 가격 : ${it.price}")
    } // let 상품명 : [초특가] 코틀린 쿡북2, 가격 : 28000

    // 5. also
    // 로깅이나 디버그 정보를 출력하는 것과 같이 객체를 변화시키지 않는 부가적인 작업에 적합하다.
    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one : $it") } // The list elements before adding new one : [one, two, three]
        .add("four")
    println(numbers) // [one, two, three, four]
}