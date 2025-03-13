import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()

    br.readLine().split(" ").map { it.toInt() }.forEach { pq.add(it) }

    repeat(n - 1) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (num in input) {
            if(num > pq.peek()) {
                pq.poll()
                pq.add(num)
            }
        }
    }
    print(pq.peek())
}
