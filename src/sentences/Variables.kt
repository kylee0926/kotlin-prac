package sentences

fun main() {

    // -------------------------------------------------------
    // 1. 변수 선언
    // -------------------------------------------------------
    // Python : x = 10
    // Kotlin : val(불변) / var(가변) 구분 필수

    val immutable = 10       // 재할당 불가 (Python의 상수처럼 사용)
    var mutable = 20         // 재할당 가능
    mutable = 30             // OK
    // immutable = 99        // 컴파일 에러

    // -------------------------------------------------------
    // 2. 타입 명시 (선택적)
    // -------------------------------------------------------
    // Python : 타입힌트는 선택 (x: int = 10)
    // Kotlin : 추론 가능하면 생략 가능, 명시도 가능

    val age: Int = 27
    val name: String = "kylee"
    val score = 98.5         // Double로 자동 추론

    // -------------------------------------------------------
    // 3. 기본 타입
    // -------------------------------------------------------
    // Python  : int, float, str, bool
    // Kotlin  : Int, Long, Double, Float, String, Boolean
    //           (모두 대문자 시작 — 객체 취급)

    val a: Int = 100
    val b: Long = 100L
    val c: Double = 3.14
    val d: Float = 3.14f
    val e: Boolean = true
    val f: String = "hello"

    // -------------------------------------------------------
    // 4. 문자열 템플릿
    // -------------------------------------------------------
    // Python : f"Hello, {name}!"
    // Kotlin : "Hello, $name!"  또는 식이면 ${식}

    val greeting = "Hello, $name! age=${age + 1}"
    println(greeting)

    // 여러 줄 문자열
    // Python : """..."""
    // Kotlin : """..."""  (동일)
    val multiLine = """
        name : $name
        age  : $age
    """.trimIndent()
    println(multiLine)

    // -------------------------------------------------------
    // 5. 상수 (컴파일 타임)
    // -------------------------------------------------------
    // Python : 관례적으로 MAX_SIZE = 100 (강제 X)
    // Kotlin : const val 은 object/companion object/top-level 에서만 가능
    //          → 아래 파일 최상단 또는 object 안에 선언

    println("MAX_SIZE = $MAX_SIZE")
}

// top-level 상수 (클래스 밖)
const val MAX_SIZE = 100
