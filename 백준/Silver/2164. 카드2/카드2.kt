fun main(){
    val N = readLine()!!.toInt()
    val deque = ArrayDeque<Int>((1..N).toList())

    repeat(N-1) {
        deque.removeFirst()
        deque.addLast(deque.removeFirst())
    }

    print(deque.removeFirst())
}