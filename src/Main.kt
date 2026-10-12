import kotlin.reflect.typeOf

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    val readOnly = mapOf("apple" to 1000, "apple" to 1200, "kiwi" to 190)
    val menu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 90)
    menu["strawberry"] = 1090
    menu.remove("strawberr")
    print(menu) // 키가 중복되면 뒤에거가 나옴
    print(menu.keys)
    print(menu.values)
}