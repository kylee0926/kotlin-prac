class Solution {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        val person = mutableMapOf<String, Int>()

        for (part in participant) {
            val cnt = person[part] ?: 0
            person[part] = cnt + 1
        }
        for (comp in completion) {
            val cnt = person[comp] ?: 0
            person[comp] = cnt - 1
        }
        for ((name, count) in person) {
            if (count == 1) return name
        }
        return ""
    }
}

"""
map을 for문할때는 for ((k,v) in map){}
"""