package sentences

// -------------------------------------------------------
// 1. 기본 클래스
// -------------------------------------------------------
// Python :
//   class Person:
//       def __init__(self, name: str, age: int):
//           self.name = name
//           self.age = age
//
// Kotlin : 생성자를 클래스 헤더에 바로 선언
//          프로퍼티도 val/var로 헤더에서 바로 선언 가능

class Person(val name: String, var age: Int) {

    // 메서드
    // Python : def greet(self): ...
    // Kotlin : self 없음, 그냥 fun
    fun greet() {
        println("Hi, I'm $name, age $age")
    }

    // Python의 __str__ 대응
    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}

// -------------------------------------------------------
// 2. data class (Python의 dataclass / Pydantic 모델과 유사)
// -------------------------------------------------------
// Python :
//   from dataclasses import dataclass
//   @dataclass
//   class User:
//       id: int
//       username: str
//
// Kotlin : data class 키워드 하나로
//   - toString(), equals(), hashCode(), copy() 자동 생성

data class User(val id: Int, val username: String, val email: String)

// -------------------------------------------------------
// 3. 상속
// -------------------------------------------------------
// Python : class Admin(User): ...
// Kotlin : 기본적으로 모든 클래스는 final (상속 불가)
//          상속 허용하려면 open 키워드 필요

open class Animal(val name: String) {
    open fun sound() {
        println("$name makes a sound")
    }
}

class Dog(name: String) : Animal(name) {
    override fun sound() {
        println("$name says Woof!")
    }
}

// -------------------------------------------------------
// 4. interface
// -------------------------------------------------------
// Python : ABC + abstractmethod
// Kotlin : interface (default 구현도 가능)

interface Serializable {
    fun serialize(): String
    fun deserialize(data: String) {   // default 구현
        println("deserializing: $data")
    }
}

data class Article(val title: String, val content: String) : Serializable {
    override fun serialize(): String = """{"title":"$title","content":"$content"}"""
}

// -------------------------------------------------------
// 5. object (싱글톤)
// -------------------------------------------------------
// Python : 모듈 레벨 변수로 싱글톤 흉내
// Kotlin : object 키워드로 싱글톤 보장

object DatabaseConfig {
    const val HOST = "localhost"
    const val PORT = 5432
    fun url() = "jdbc:postgresql://$HOST:$PORT/mydb"
}

// -------------------------------------------------------
// 6. companion object (Python의 @classmethod / @staticmethod)
// -------------------------------------------------------
class UserFactory(val name: String) {
    companion object {
        fun create(name: String) = UserFactory(name)
        const val DEFAULT_NAME = "anonymous"
    }
}

// -------------------------------------------------------
// 7. enum class
// -------------------------------------------------------
// Python : from enum import Enum
// Kotlin : enum class

enum class Role {
    ADMIN, STAFF, USER
}

fun main() {
    // 기본 클래스
    val person = Person("kylee", 27)
    person.greet()
    println(person)

    // data class : copy() 활용 (Django 모델 업데이트 패턴과 유사)
    val user = User(1, "kylee", "kylee@example.com")
    val updated = user.copy(email = "new@example.com")
    println(user)
    println(updated)

    // equals 자동 구현
    val user2 = User(1, "kylee", "kylee@example.com")
    println(user == user2)   // true (data class라 내용 비교)

    // 상속
    val dog = Dog("Buddy")
    dog.sound()

    // interface
    val article = Article("Kotlin", "It's great")
    println(article.serialize())
    article.deserialize("""{"title":"Kotlin"}""")

    // object 싱글톤
    println(DatabaseConfig.url())

    // companion object
    val newUser = UserFactory.create("alice")
    println(newUser.name)
    println(UserFactory.DEFAULT_NAME)

    // enum
    val role = Role.ADMIN
    when (role) {
        Role.ADMIN -> println("관리자")
        Role.STAFF -> println("스태프")
        Role.USER  -> println("일반 사용자")
    }
}
