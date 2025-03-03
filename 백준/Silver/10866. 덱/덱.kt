import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val deque = LinkedList<Int>()
    val result = StringBuilder()

    repeat(N){
        val order = br.readLine().split(" ")
        when(order[0]){
            "push_front" -> deque.addFirst(order[1].toInt())
            "push_back" -> deque.addLast(order[1].toInt())
            "pop_front" -> result.append(if (deque.isEmpty()) -1 else deque.removeFirst()).append("\n")
            "pop_back" -> result.append(if (deque.isEmpty()) -1 else deque.removeLast()).append("\n")
            "size" -> result.append(deque.size).append("\n")
            "empty" -> result.append(if (deque.isEmpty()) 1 else 0).append("\n")
            "front" -> result.append(if (deque.isEmpty()) -1 else deque.peekFirst()).append("\n")
            "back" -> result.append(if (deque.isEmpty()) -1 else deque.peekLast()).append("\n")
        }
    }
    print(result.toString())
}