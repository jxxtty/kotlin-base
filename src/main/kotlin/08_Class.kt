class Person(var name:String, val birthYear: Int)

class Person2(var name:String, val birthYear: Int){
    init{
        println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")
    }

    fun introduce() {
        println("안녕하세요, ${birthYear}년생 ${name}입니다.")
    }

    // 보조 생성자
    // 필요에 따라 추가적으로 선언해서 사용한다.
    // 주의할 점 : 보조 생성자를 만들 때는 반드시 기본 생성자를 통해 속성을 초기화 해줘야 한다.
    //          -> 콜론(:)을 붙인 후에 this 키워드를 사용하고 기본생성자가 필요로하는 파라미터를 괄호안에 넣어준다.
    constructor(name: String): this(name, 1997){
        println("보조생성자가 호출되었습니다. : ${this.name}")
    }
}

fun main() {
    var a = Person("박보영", 1990)
    var b = Person("전정국", 1997)
    var c = Person("장원영", 2004)

    println("안녕하세요, ${a.birthYear}년생 ${a.name}입니다.")
    println("안녕하세요, ${b.birthYear}년생 ${b.name}입니다.")
    println("안녕하세요, ${c.birthYear}년생 ${c.name}입니다.")

    println("----------------------------")

    // 이렇게 공통되는 기능을 넣어주고 싶다면, 클래스 내에 함수로 넣어준다. -> Person2
    // +) init 함수 : 파라미터나 반환형이 없는 특수한 함수, 생성자를 통해 인스턴스가 만들어질 때 자동으로 호출된다.
    var aa = Person2("박보영", 1990)
    var bb = Person2("전정국", 1997)
    var cc = Person2("장원영", 2004)
    aa.introduce()
    bb.introduce()
    cc.introduce()

    println("----------------------------")

    // 기본 생성자 외에 보조 생성자를 둘 수 있다.
    var aaa = Person2("차은우")
    var bbb = Person2("류수정")
}