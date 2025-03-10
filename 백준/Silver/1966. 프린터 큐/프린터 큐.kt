import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val t = br.readLine().toInt()

    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val priorities = br.readLine().split(" ").map { it.toInt() }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

        //indices : 리스트의 인덱스 순회
        for (i in priorities.indices) {
            queue.add(Pair(i, priorities[i]))
            priorityQueue.add(priorities[i])
        }

        var count = 0

        while (queue.isNotEmpty()) {
            val (index, priority) = queue.poll()
            if (priority == priorityQueue.peek()) {
                priorityQueue.poll()
                count++
                if (index == m) {
                    sb.appendLine(count)
                    break
                }
            } else {
                queue.add(Pair(index, priority))
            }
        }
    }
    print(sb)
}