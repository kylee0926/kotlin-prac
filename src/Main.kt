fun uppercaseString(text: String): String {
    return text.uppercase()
}


fun main() {
    val upperCaseString: String = {text: String -> text.uppercase()}
    println(upperCaseString)
}