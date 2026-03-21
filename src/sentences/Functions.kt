package sentences

// -------------------------------------------------------
// 1. 기본 함수
// -------------------------------------------------------
// Python :
//   def add(a: int, b: int) -> int:
//       return a + b
//
// Kotlin :
//   fun add(a: Int, b: Int): Int { return a + b }

fun add(a: Int, b: Int): Int {
    return a + b
}

// 단일 표현식이면 = 으로 축약 가능 (Python에는 없는 문법)
fun addShort(a: Int, b: Int): Int = a + b

// -------------------------------------------------------
// 2. 반환 타입 없음
// -------------------------------------------------------
// Python : def greet(name: str) -> None:
// Kotlin : fun greet(name: String): Unit  → Unit 생략 가능

fun greet(name: String) {
    println("Hello, $name")
}

// -------------------------------------------------------
// 3. 기본값 파라미터
// -------------------------------------------------------
// Python : def connect(host: str, port: int = 8000): ...
// Kotlin : 동일하게 지원

fun connect(host: String, port: Int = 8000) {
    println("connecting to $host:$port")
}

// -------------------------------------------------------
// 4. 이름 있는 인자 (Named Arguments)
// -------------------------------------------------------
// Python : connect(port=3000, host="localhost")
// Kotlin : 동일하게 지원

// -------------------------------------------------------
// 5. 가변 인자
// -------------------------------------------------------
// Python : def sum_all(*args): ...
// Kotlin : vararg 키워드 사용

fun sumAll(vararg numbers: Int): Int {
    return numbers.sum()
}

// -------------------------------------------------------
// 6. 고차 함수 (함수를 인자로)
// -------------------------------------------------------
// Python :
//   def apply(value: int, func) -> int:
//       return func(value)
//
// Kotlin : 파라미터 타입에 함수 타입 명시 필수
//   (Int) -> Int  = Int를 받아 Int를 반환하는 함수

fun apply(value: Int, func: (Int) -> Int): Int {
    return func(value)
}

// -------------------------------------------------------
// 7. 람다 (Lambda)
// -------------------------------------------------------
// Python : lambda x: x * 2
// Kotlin : { x: Int -> x * 2 }  또는 파라미터 1개면 it 사용

fun main() {
    println(add(1, 2))
    println(addShort(3, 4))

    greet("kylee")

    connect("localhost")           // port = 8000 (기본값)
    connect(port = 3000, host = "db")  // named argument

    println(sumAll(1, 2, 3, 4, 5))

    // 람다 전달
    val result = apply(10) { it * 2 }  // 마지막 인자가 람다면 괄호 밖으로 뺄 수 있음
    println(result)  // 20

    // 람다 변수에 저장
    val double: (Int) -> Int = { x -> x * 2 }
    val square: (Int) -> Int = { it * it }  // 인자 1개면 it 으로 생략
    println(double(5))   // 10
    println(square(4))   // 16

    // Python의 map/filter와 동일
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    val evens = numbers.filter { it % 2 == 0 }
    println(doubled)  // [2, 4, 6, 8, 10]
    println(evens)    // [2, 4]
}
