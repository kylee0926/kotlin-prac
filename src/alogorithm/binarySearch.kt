package alogorithm

fun binarySearch(target: Int){
    val binarySearchList = (1..1000).toList()
    var startIndex = 0
    var endIndex = binarySearchList.size - 1
    var midIndex = (startIndex + endIndex) / 2

    while (startIndex <= endIndex){
        var value: Int = binarySearchList[midIndex]
        if (value > target){
            endIndex = midIndex - 1
        }
        else if (value < target){
            startIndex = midIndex + 1
        }
        else{
            println("final $midIndex")
            break
        }
        midIndex = (startIndex + endIndex) / 2
    }
}
