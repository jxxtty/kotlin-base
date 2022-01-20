open class Animal2 {
    open fun eat() { // 메소드단에 open -> overriding 허용
        println("냠냠")
    }
}

class Tiger: Animal2() {
    override fun eat() { // 슈퍼클래스에서 구현이 끝난 메소드(eat)을 서브클래스에서 재정의하여 사용
        println("호랭쓰 냠냠")
    }
}
fun main() {
    var tiger = Tiger()
    tiger.eat() // 호랭쓰 냠냠

    var animal2 = Animal2()
    animal2.eat() // 냠냠
}