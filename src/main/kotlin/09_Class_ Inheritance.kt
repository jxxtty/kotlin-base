// 상속이 필요한 경우
// 1. 이미 존재하는 클래스에 새로운 속성이나 함수를 추가하여 클래스를 만들어야 할 때
// 2. 여러 개의 클래스를 만들었는데, 이 클래스들의 공통점을 뽑아 코드관리를 편하게 하고 싶을 때

// 부모(물려주는 쪽) : 슈퍼클래스
//  ㅣ
// 자식(물려받는 쪽) : 서브클래스

// Kotlin 에서는 상속 금지가 default 다. 따라서 상속을 허용하고 싶다면 클래스앞에 open 키워드를 붙여줘야 한다.

// 상속의 규칙
// 1. 서브클래스는 슈퍼클래스에 존재하는 속성과 같은 이름의 속성을 가질 수 없다.
// 2. 서브클래스가 생성될 때는 반드시 슈퍼 클래스의 생성자까지 호출되어야 한다.

open class Animal(var name: String, var age: Int, var type: String) {
    fun introduce() {
        println("종 : ${type}, 이름 : ${name}, 나이 : ${age}")
    }
}

class Dog(name: String, age: Int) : Animal(name, age, "개") // 슈퍼클래스의 기본생성자가 호출된다.

class Cat(name: String, age: Int) : Animal(name, age, "고양이") {
    fun meow() {
        println("야옹")
    }
}

fun main() {
    var animal = Animal("멍멍이", 5, "개")
    var dog = Dog("멍멍이", 5)

    animal.introduce() // 종 : 개, 이름 : 멍멍이, 나이 : 5
    dog.introduce() // 종 : 개, 이름 : 멍멍이, 나이 : 5

    var animal2 = Animal("나비", 5, "고양이")
    var cat = Cat("나비", 5)
    // animal2.meow()
    cat.meow()
}