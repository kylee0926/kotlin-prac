package alogorithm

class Node(val value: Int?) {
    var data: Int? = value
    var next: Node? = null
}

class LinkedList(value: Int?) {
    var head: Node? = Node(value = value)

    fun getAllValues(){
        var newList = mutableListOf<Int>()
        var cur = head
        while (cur != null) {
            newList.add(cur?.value!!)
            cur = cur.next
        }
        println(newList)
    }

    fun getNode(index: Int): Node? {
        var cur = head
        var startIndex = 0
        while (startIndex < index){
            cur = cur?.next
            startIndex += 1
        }
        return cur
    }

    fun appendNode(value: Int){
        var cur = head
        while (cur?.next != null) {
            cur = cur.next
        }
        cur?.next = Node(value = value)
    }

    fun addNode(index: Int, value: Int){
        if (index == 0){
            var newHead = Node(value = value)
            newHead.next = head
            head = newHead
        }
        else{
            var nowNode = getNode(index)
            var prevNode = getNode(index - 1)
            var newNode = Node(value = value)
            prevNode?.next = newNode
            newNode.next = nowNode
        }
    }

    fun deleteNode(index: Int){
        if (index == 0){
            head = head?.next
        }
        else{
            var nowNode = getNode(index)
            var prevNode = getNode(index - 1)
            prevNode?.next = nowNode?.next
        }
    }
}

fun start(){
    var linkedList = LinkedList(5)
    linkedList.appendNode(6)
    linkedList.appendNode(8)
    linkedList.addNode(0,4)
    linkedList.addNode(3, 7)
    linkedList.getAllValues()
    linkedList.deleteNode(2)
    linkedList.getAllValues()
}