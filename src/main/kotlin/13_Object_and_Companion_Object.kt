// 클래스는 단지 인스턴스 객체를 만들기 위한 '틀' -> 내부의 속성이나 함수를 사용하려면 실체가 되는 인스턴스 객체를 만들어야 했다. (var p = Person("박보영", 1990))
// 그러나 여러 개의 인스턴스 객체가 필요하지 않으며 단 하나의 객체만으로 공통적인 속성과 함수를 사용해야하는 경우라면 클래스가 아니라 Object를 사용하면 된다.
// Kotlin의 Object는 singleton pattern을 언어적인 차원에서 제공하는 것이다.

// Object는 그 자체로 객체이기 때문에 생성자를 사용하지 않는다.
// Object로 선언된 객체는 최초 사용시 자동으로 생성되며, 이후에는 코드 전체에서 공용으로 사용될 수 있다.
object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}

// Companion Object
// 기존 클래스 안에 Object를 생성한다
// 클래스의 인스턴스 기능은 그대로 사용하면서, 인스턴스 간에 공용 속성 및 함수를 두어 사용한다
class FoodPoll(val name: String){
    companion object {
        var totalCount = 0 // 전체 투표수
    }

    var count = 0 // 개별 투표수

    fun vote() {
        totalCount++
        count++
    }

}

fun main() {
    // Object
    println(Counter.count) // 0

    Counter.countUp()
    Counter.countUp()

    println(Counter.count) // 2

    Counter.clear()

    println(Counter.count) // 0


    // Companion Object
    var a = FoodPoll("찍먹")
    var b = FoodPoll("부먹")

    a.vote()
    a.vote()
    a.vote()

    b.vote()
    b.vote()

    println("${a.name} : ${a.count}") // 찍먹 : 3
    println("${b.name} : ${b.count}") // 부먹 : 2
    println("총 투표수 : ${FoodPoll.totalCount}") // 총 투표수 : 5
}