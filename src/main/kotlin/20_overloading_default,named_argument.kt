fun main(){
    // overloading
    read(7)
    read("7")

    // default argument
    deliveryItem("책")
    deliveryItem("짬뽕", 3)
    deliveryItem("노트북", 30, "회사")

    // named argument
    // name, destination 값만 전달하고 싶다면?
    deliveryItem("선물", destination = "칭구집")
}

fun read(x: Int) {
    println("read-Int : $x 입니다")
}

fun read(x: String){
    println("read-String : $x 입니다")
}

fun deliveryItem(name: String, count: Int = 1, destination: String = "우리집"){
    println("$name $count 개를 $destination 에 배달했습니다.")
}