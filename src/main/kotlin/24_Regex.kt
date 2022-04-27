fun main() {
    var _regex = "(\\d{2,3}\\s?[가-마거-처고-조구-주]{1}\\s?\\d{4}|\\d{2,3}\\s?[바-자배]{1}\\s?\\d{4}|\\d{2,3}\\s?[허하호]{1}\\s?\\d{4}|\\d{2,3}\\s?(외교|영사|준외|준영|국기|협정|대표)\\s?\\d{4})".toRegex()
    var _target = "157하8281(어린이보호구역)"
    var _target2 = "123123"
    var _target3 = "123마1234"


    // ----------------------------------------------------------------------------------------
    // Regex.containsMatchIn(): Boolean -> 부분적으로 패턴이 일치하면 true
    // Regex.matches(): Boolean -> 모든 패턴이 일치하면 true
    println(_regex.containsMatchIn(_target)) // true
    println(_regex.containsMatchIn(_target3)) // true

    println(_regex.matches(_target)) // false
    println(_regex.matches(_target3)) // true



    // ----------------------------------------------------------------------------------------
    // Regex.matchEntire(): MatchResult?
    // 문자열과 패턴이 일치하는지를 검사하며 일치하면 MatchResult를, 일치하지 않으면 null을 리턴한다
    var test = _regex.matchEntire(_target)
    var test2 = _regex.matchEntire(_target2)
    var test3 = _regex.matchEntire(_target3)
    println(test?.value) // null
    println(test2?.value) // null
    println(test3?.value) // 123마1234



    // ----------------------------------------------------------------------------------------
    // Regex.find(): MatchResult?
    // 문자열과 패턴이 완전히 일치하지 않는, 부분적으로만 일치하는 문자열을 찾아준다.
    // 일치하는 문자열이 있다면 MatchResult를, 일치하는 문자열이 없다면 null을 리턴한다.
    var test4 = _regex.find(_target)
    var test5 = _regex.find(_target2)
    println(test4?.value) // 157하8281
    println(test5?.value) // null



    // ----------------------------------------------------------------------------------------
    // Group
    var str1 = "apple likes banana"
    var str2 = "kiwi likes blueberry"
    var _regex2 = "(apple|kiwi) likes (banana|blueberry)".toRegex()

    var result1 = _regex2.matchEntire(str1)
    var result2 = _regex2.matchEntire(str2)
    println(result1?.groupValues) // [apple likes banana, apple, banana]
    println(result2?.groupValues) // [kiwi likes blueberry, kiwi, blueberry]



    // ----------------------------------------------------------------------------------------
    // Regex.findAll(): Sequence<MatchResult>
    // 문자열에서 어떤 패턴과 부분적으로 일치하는 모든 문자열들을 찾을 때 사용한다
    // Sequence로 리턴되기 때문에 Iteration을 통해 접근할 수 있다.
    var str = "abcd abce"
    var _regex3 = "abc([de]+)".toRegex()
    var sequenceResult = _regex3.findAll(str)

    sequenceResult?.forEach {
        println("match result: ${it.value}")
    }
    // match result: abcd
    // match result: abce



    // ----------------------------------------------------------------------------------------
    // Regex.replace() -> 패턴과 일치하는 모든 문자열을 교체한다.
    // Regex.replaceFirst() -> 패턴과 일치하는 첫번째 문자열만 교체한다.
    var sample = "abcda abcef"
    var replaceResult = _regex3.replace(sample, "ABC")
    var replaceFirstResult = _regex3.replaceFirst(sample, "ABC")
    println(replaceResult) // ABCa ABCf
    println(replaceFirstResult) // ABCa abcef



    // ----------------------------------------------------------------------------------------
    // Regex.split() -> 패턴과 일치하는 문자열을 기준으로 분리하여 List로 리턴
    var sample2 = "a b c d e f"
    var sample3 = "abc def hig lmn op"
    var _regex4 = "\\s".toRegex()

    var splitListResult = _regex4.split(sample2)
    println(splitListResult) // [a, b, c, d, e, f]
    var splitListResult2 = _regex4.split(sample3)
    println(splitListResult2) // [abc, def, hig, lmn, op]
}