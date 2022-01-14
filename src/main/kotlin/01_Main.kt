fun main(args: Array<String>) { // Array<String>을 args로 받겠다. -> Java로 치면 (String[] args)
    println("Hello World!")

    println("Program arguments: ${args.joinToString()}") // Program arguments: Hi, Hello, My, Name, Is, Jxxtty
    println(args.contentToString()) // [Hi, Hello, My, Name, Is, Jxxtty]
    println(args.size) // 6

    println("------------")

    for (arg in args) {
        println(arg)
    }



}