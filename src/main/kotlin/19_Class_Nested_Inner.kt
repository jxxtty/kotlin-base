fun main() {
    // 중첩클래스의 경우 "[outer클래스명].[중첩클래스명]()"이런식으로 사용한다
    OuterClass.NestedClass().introduce() // Nested Class!

    var nested = OuterClass.NestedClass()
    nested.introduce() // Nested Class!

    // inner 클래스의 경우 혼자서는 객체를 생성할 수 없고, "외부클래스의 객체"가 있어야 내부클래스의 객체 생성과 사용이 가능하다
    val outer = OuterClass()
    val inner = outer.InnerClass() // val inner = OuterClass().InnerClass()

    inner.introduce() // hello this is Outer Class  / Inner Class!
    inner.introduceOuterAndInner() // Inner Class text  / Outer Class text

    outer.hello = "Changed hello message"
    inner.introduce() // Changed hello message  / Inner Class!
}

class OuterClass {
    var text = "Outer Class text"
    var hello = "hello this is Outer Class"

    class NestedClass {
        fun introduce() {
            // println(hello) // 외부 클래스의 내용을 공유할 수 없다. -> 호출불가
            println("Nested Class!")
        }
    }

    inner class InnerClass {
        var text = "Inner Class text"

        fun introduce(){
            print("$hello  / ")
            println("Inner Class!")
        }

        fun introduceOuterAndInner(){
            print("$text  / ")
            println(this@OuterClass.text) // inner와 outer에 동일한 변수명이 있다면 "this@[outer클래스명].변수명" 이렇게 접근 가능하다
        }
    }
}