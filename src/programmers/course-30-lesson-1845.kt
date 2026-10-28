class Solution{
    fun solution(nums: List<Int>){
        val numSize: Int = nums.size / 2
        val uniqueNumSize: Int = nums.toSet().size
        return minOf(numSize, uniqueNumSize)
    }
}

fun main(){
    Solution().solution([3,1,2,3])
}