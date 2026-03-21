package sentences

fun main() {

    val score = 85

    // -------------------------------------------------------
    // 1. if / else
    // -------------------------------------------------------
    // Python : 동일하나 콜론(:) + 들여쓰기
    // Kotlin : 중괄호 사용, 단 if 자체가 "식(expression)"이라 값 반환 가능

    // Python :
    //   grade = "pass" if score >= 60 else "fail"  (삼항)

    // Kotlin : if를 식으로 사용 (삼항연산자 없음 — if가 대체)
    val grade = if (score >= 60) "pass" else "fail"
    println(grade)

    // -------------------------------------------------------
    // 2. when (Python의 match-case / if-elif-else 대체)
    // -------------------------------------------------------
    // Python 3.10+ :
    //   match score // 10:
    //       case 10 | 9: print("A")
    //       case 8:      print("B")
    //       ...
    //
    // Kotlin : when 이 훨씬 강력하고 표현식으로도 사용 가능

    val letter = when (score / 10) {
        10, 9 -> "A"
        8     -> "B"
        7     -> "C"
        else  -> "F"
    }
    println(letter)

    // 범위(range) 조건
    val comment = when (score) {
        in 90..100 -> "Excellent"
        in 70..89  -> "Good"
        in 60..69  -> "Pass"
        else       -> "Fail"
    }
    println(comment)

    // 인자 없는 when → if-elif-else 대체
    val x = 15
    when {
        x < 0   -> println("negative")
        x == 0  -> println("zero")
        x < 10  -> println("small")
        else    -> println("large")
    }

    // -------------------------------------------------------
    // 3. for 루프
    // -------------------------------------------------------
    // Python : for i in range(1, 6):
    // Kotlin : for (i in 1..5)  또는  1.rangeTo(5)

    for (i in 1..5) print("$i ")   // 1 2 3 4 5 (끝 포함)
    println()
    for (i in 1 until 5) print("$i ")  // 1 2 3 4 (끝 미포함, Python range와 동일)
    println()
    for (i in 5 downTo 1) print("$i ")  // 5 4 3 2 1
    println()
    for (i in 1..10 step 2) print("$i ")  // 1 3 5 7 9
    println()

    // 컬렉션 순회
    // Python : for item in items:
    // Kotlin : 동일
    val items = listOf("a", "b", "c")
    for (item in items) print("$item ")
    println()

    // 인덱스와 함께
    // Python : for i, item in enumerate(items):
    // Kotlin : forEachIndexed 또는 withIndex()
    for ((index, value) in items.withIndex()) {
        println("[$index] $value")
    }

    // -------------------------------------------------------
    // 4. while
    // -------------------------------------------------------
    // Python / Kotlin 거의 동일
    var count = 0
    while (count < 3) {
        println("count = $count")
        count++
    }

    // -------------------------------------------------------
    // 5. break / continue
    // -------------------------------------------------------
    // Python / Kotlin 동일. Kotlin은 레이블(label) 기능 추가
    for (i in 1..5) {
        if (i == 3) continue
        if (i == 5) break
        print("$i ")   // 1 2 4
    }
    println()
}
