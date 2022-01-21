package cookBook

// Task의 속성은 name과 priority 뿐이다.
class Task(val name: String, _priority: Int = DEFAULT_PRIORITY) { // _priority는 생성자의 인자일 뿐 속성이 아니다.
    companion object {
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    // 프로퍼티 priority에 사용자정의 setter
    var priority = validPriority(_priority)
        set(value) {
            println("사용자 정의 setter 호출되었음")
            field = validPriority(value)
        }

    private fun validPriority(p: Int) = p.coerceIn(MIN_PRIORITY, MAX_PRIORITY).also { println("validPriority호출") } // coerceIn : 범위를 한정하는 함수
}

fun main() {
    var task1 = Task("task1", 2)
    println("${task1.name} , ${task1.priority}") // task1 , 2

    task1.priority = 10
    println("값 변경 : ${task1.name} , ${task1.priority}") // 값 변경 : task1 , 5
                                                         // -> MAX가 5라서 10으로 변경했지만 5로 변경됐다.

}