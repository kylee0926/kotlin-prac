package sentences

fun main() {

    // -------------------------------------------------------
    // 1. Nullable 타입
    // -------------------------------------------------------
    // Python : 모든 변수에 None 할당 가능 → 런타임에 오류 발생
    // Kotlin : 타입에 ? 를 붙여야만 null 허용 → 컴파일 타임에 차단

    val nonNull: String = "hello"
    // nonNull = null   // 컴파일 에러

    val nullable: String? = null   // ? 붙이면 null 허용

    // -------------------------------------------------------
    // 2. 안전 호출 연산자 ?.
    // -------------------------------------------------------
    // Python :
    //   length = len(text) if text is not None else None
    //
    // Kotlin : text?.length  → null이면 null 반환, 아니면 실행

    val text: String? = "Kotlin"
    println(text?.length)    // 6

    val empty: String? = null
    println(empty?.length)   // null (NPE 없음)

    // -------------------------------------------------------
    // 3. Elvis 연산자 ?:
    // -------------------------------------------------------
    // Python :
    //   length = len(text) if text is not None else 0
    //   또는 : length = text and len(text) or 0
    //
    // Kotlin : text?.length ?: 0  → null이면 0 반환

    val length = empty?.length ?: 0
    println(length)  // 0

    // Django 뷰에서 자주 쓰이는 패턴과 유사:
    //   user = request.user if request.user.is_authenticated else None
    //   → Kotlin: val user = getUser() ?: return

    // -------------------------------------------------------
    // 4. !! (Non-null 단언)
    // -------------------------------------------------------
    // "이 값은 절대 null이 아님을 내가 보장한다"
    // null이면 NPE 발생 — 확실한 경우에만 사용

    val definitelyNotNull: String = text!!   // text가 null이면 NPE
    println(definitelyNotNull.length)

    // -------------------------------------------------------
    // 5. let 과 결합 (null이 아닐 때만 블록 실행)
    // -------------------------------------------------------
    // Python :
    //   if user is not None:
    //       send_email(user)
    //
    // Kotlin : user?.let { send_email(it) }

    val user: String? = "kylee"
    user?.let {
        println("sending email to $it")   // null이 아닐 때만 실행
    }

    val noUser: String? = null
    noUser?.let {
        println("이 줄은 실행되지 않음")
    }

    // -------------------------------------------------------
    // 6. 스마트 캐스트 (Smart Cast)
    // -------------------------------------------------------
    // if로 null 체크 후에는 자동으로 non-null 타입으로 처리

    val value: String? = "hello"
    if (value != null) {
        println(value.length)   // 여기선 value가 String으로 스마트 캐스트됨
    }
}
