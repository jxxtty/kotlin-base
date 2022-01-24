// Cola 인스턴스를 Drink타입의 변수에 담는 행위를 'up-casting'이라 한다.(상위 자료형인 슈퍼클래스로 변환한다는 뜻)
// up-casting 된 인스턴스를 다시 하위 자료형(Cola)로 변환하는 행위를 'down-casting'이라 한다.

// up-casting은 상위 자료형에 하위 자료형을 담는 것으로 끝이지만,
// down-casting은 별도의 연산자가 필요하다.
// 연산자 : as, is


fun main() {
    // up-casting
    var a: Drink = Cola() // Drink의 객체 공간만 사용 가능하다 -> up-casting
    var b: Cola = Cola() // Drink의 객체 공간 + Cola의 객체공간 모두 사용가능

    a.drink()
    // a.cola() 호출불가

    b.drink()
    b.cola()

    // down-casting
    // 1. as 연산자 : 변수를 호환되는 자료형으로 변환해주는 캐스팅 연산자
    var c: Drink = Cola()
    var d = c as Cola // d의 자료형 : Cola , c의 자료형 : Cola -> as를 사용하면 c에도 다운캐스팅이 적용된다.

    // 2. is 연산자 : 변수가 자료형에 호환되는지를 먼저 체크한 후 변환해주는 캐스팅 연산자, 조건문 내에서만 사용된다는 특징이 있다.
    if(a is Cola){
        println("a의 자료형은 Cola 입니다.")
    } else {
        println("a의 자료형은 Cola가 아닙니다.")
    } // a의 자료형은 Cola 입니다. -> a의 자료형이 Drink였는데 이런 결과가 출력되는 이유는, is연산자가 호환되는지를 체크한 후에 변환까지 진행하기 때문이다. 'a is Cola' 조건에서 이미 a는 Cola로 downcasting이 완료됐다.


    var drink = Drink()
    drink.drink()

    var cola: Drink = Cola()
    cola.drink()
    // cola.washDishes() // cola는 현재 Drink변수이므로 washDishes는 호출 불가하다

    if(cola is Cola){ // is연산자 -> 호환되는지 체크 후 다운캐스팅 진행 -> cola의 자료형이 Cola가 된다
        cola.washDishes() // 따라서 washDishes 호출 가능
    }
    // cola.washDishes() // if문 블럭 안에서만 다운캐스팅 된다.(washDishes 호출 불가)

    var cola2 = cola as Cola
    cola2.washDishes()
    cola.washDishes() // as 연산자 -> cola까지 다운캐스팅 한다 -> washDishes 호출가능
}

open class Drink {
    var name = "음료"

    fun drink() {
        println("drink")
    }

    open fun doSomething() {
        println("$name 를 마십니다")
    }
}

class Cola : Drink() {
    var type = "콜라"

    fun cola(){
        println("cola")
    }

    override fun doSomething() {
        println("$name 중에 $type 을 마십니다")
    }

    fun washDishes() {
        println("$type 를 마신 컵을 설거지 합니다")
    }
}