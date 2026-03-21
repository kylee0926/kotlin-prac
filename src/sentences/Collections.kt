package sentences

fun main() {

    // -------------------------------------------------------
    // Kotlin 컬렉션의 핵심 : Immutable / Mutable 구분
    // Python은 list/dict/set 모두 기본이 mutable
    // Kotlin은 선언 시점에 변경 가능 여부를 명시
    // -------------------------------------------------------

    // -------------------------------------------------------
    // 1. List
    // -------------------------------------------------------
    // Python : items = [1, 2, 3]  (mutable)
    // Kotlin :
    //   listOf(...)    → 읽기 전용 (immutable)
    //   mutableListOf(...) → 변경 가능

    val readOnlyList = listOf(1, 2, 3)
    // readOnlyList.add(4)   // 컴파일 에러

    val mutableList = mutableListOf(1, 2, 3)
    mutableList.add(4)
    mutableList.remove(1)
    println(mutableList)   // [2, 3, 4]

    // 인덱스 접근
    println(readOnlyList[0])          // 1
    println(readOnlyList.first())     // 1
    println(readOnlyList.last())      // 3

    // -------------------------------------------------------
    // 2. Map (Python의 dict)
    // -------------------------------------------------------
    // Python : d = {"key": "value"}
    // Kotlin :
    //   mapOf(...)        → 읽기 전용
    //   mutableMapOf(...) → 변경 가능
    //   to  키워드로 Pair 생성

    val readOnlyMap = mapOf("name" to "kylee", "age" to 27)
    println(readOnlyMap["name"])           // kylee
    println(readOnlyMap.getOrDefault("job", "unknown"))  // unknown

    val mutableMap = mutableMapOf<String, Any>("name" to "kylee")
    mutableMap["age"] = 27
    mutableMap.remove("name")
    println(mutableMap)   // {age=27}

    // 순회
    // Python : for k, v in d.items():
    for ((key, value) in readOnlyMap) {
        println("$key = $value")
    }

    // -------------------------------------------------------
    // 3. Set (Python의 set)
    // -------------------------------------------------------
    // Python : s = {1, 2, 3}
    // Kotlin : setOf(...) / mutableSetOf(...)

    val readOnlySet = setOf(1, 2, 2, 3)   // 중복 제거
    println(readOnlySet)   // [1, 2, 3]

    val mutableSet = mutableSetOf("a", "b")
    mutableSet.add("c")
    println(mutableSet)

    // -------------------------------------------------------
    // 4. 컬렉션 함수 (Python의 list comprehension / 내장함수 대응)
    // -------------------------------------------------------
    val numbers = listOf(1, 2, 3, 4, 5, 6)

    // Python : [x * 2 for x in numbers]
    val doubled = numbers.map { it * 2 }
    println(doubled)  // [2, 4, 6, 8, 10, 12]

    // Python : [x for x in numbers if x % 2 == 0]
    val evens = numbers.filter { it % 2 == 0 }
    println(evens)    // [2, 4, 6]

    // Python : sum(numbers)
    println(numbers.sum())       // 21
    println(numbers.average())   // 3.5
    println(numbers.max())       // 6
    println(numbers.min())       // 1

    // Python : any(x > 5 for x in numbers)
    println(numbers.any { it > 5 })   // true

    // Python : all(x > 0 for x in numbers)
    println(numbers.all { it > 0 })   // true

    // Python : [str(x) for x in numbers]
    val strings = numbers.map { it.toString() }
    println(strings)  // [1, 2, 3, 4, 5, 6]

    // Python : sorted(numbers, reverse=True)
    println(numbers.sortedDescending())  // [6, 5, 4, 3, 2, 1]

    // Python : ",".join(strings)
    println(numbers.joinToString(", "))  // 1, 2, 3, 4, 5, 6

    // reduce (Python : functools.reduce)
    val total = numbers.reduce { acc, i -> acc + i }
    println(total)  // 21

    // groupBy (Django ORM의 values().annotate() 느낌)
    val words = listOf("apple", "banana", "avocado", "blueberry")
    val grouped = words.groupBy { it.first() }
    println(grouped)  // {a=[apple, avocado], b=[banana, blueberry]}
}
