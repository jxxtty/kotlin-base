// overriding
// 슈퍼클래스에서 구현이 끝난 메소드 -> 서브클래스에서 해당 메소드를 재정의해서 사용한다
open class Animal2 {
    open fun eat() { // 메소드단에 open -> overriding 허용
        println("냠냠")
    }
}

class Tiger: Animal2() {
    override fun eat() { // open처리 되어있는 eat메소드를 재정의
        println("호랭쓰 냠냠")
    }
}


// 추상화
// 추상클래스 : 추상함수 포함하는 클래스 -- 추상클래스는 미완성 클래스이기 때문에 단독으로는 인스턴스를 만들 수 없다.
// 슈퍼클래스(추상클래스)에서 메소드를 선언만 한다.(구현X) -> 서브클래스가 슈퍼클래스를 상속하여 'abstract' 가 붙은 메소드를 구현해야한다.
abstract class Animal3 {
    abstract fun eat()

    fun sniff() {
        println("킁킁 냄새를맡아용")
    }
}

class Rabbit : Animal3() {
    override fun eat() {
        println("토끼쓰 냠냠")
    }
}

// 인터페이스
// 추상클래스는 생성자를 가질 수 있다. 인터페이스는 생성자를 가질 수 없다.
// 인터페이스는 속성, 추상함수, 일반함수 이렇게 3가지를 가질 수 있다.
// 구현이 끝난 함수 -> open 함수로 간주
// 구현 없이 선언만 한 함수 -> abstract 함수로 간주
// => 따라서, 별도의 키워드가 없어도 인터페이스에 선언된 모든 함수를 서브클래스에서 구현 및 재정의 가능하다.
interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("Eater 냠냠")
    }
}

class JaeRong : Runner, Eater { // 한번에 여러 인터페이스를 상속받을 수 있다
    override fun run() {
        println("재롱이의 우다다다")
    }

    override fun eat() {
        println("재롱쓰 간식쓰 냠냠쓰")
    }
}

fun main() {
    // overriding ---------------------------
    var tiger = Tiger()
    tiger.eat() // 호랭쓰 냠냠

    var animal2 = Animal2()
    animal2.eat() // 냠냠


    // abstraction ---------------------------
    var rabbit = Rabbit()

    rabbit.eat() // 토끼쓰 냠냠
    rabbit.sniff() // 킁킁 냄새를맡아용


    // interface ---------------------------
    var jaeRong = JaeRong()
    jaeRong.run() // 재롱이의 우다다다
    jaeRong.eat() // 재롱쓰 간식쓰 냠냠쓰
}