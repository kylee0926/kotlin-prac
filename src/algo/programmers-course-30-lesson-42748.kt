class Solution{
    fun solution(array: List<Int>, commands: List<List<Int>>): List<Int>{
        var answer = mutableListOf<Int>()

        for (command in commands){
            val indexI: Int = command[0] - 1
            val indexJ: Int = command[1]
            val indexK: Int = command[2] - 1

            val slicedArray: List<Int> = array.slice(indexI until indexJ).sorted()
            val valueData: Int = slicedArray[indexK]
            answer.add(valueData)
        }

        return answer
    }
}

fun main(){
    println(Solution().solution(listOf(1,5,2,6,3,7,4), listOf(listOf(2,5,3), listOf(4,4,1), listOf(1,7,3))))
}

"""
1. sort한 정렬을 리턴할때 .sorted() 사용
2. slice의 경우 파이썬은 list[1:2] 이렇게하는데 코틀린은 .slice(i until j)로 함
"""