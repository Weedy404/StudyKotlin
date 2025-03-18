import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = StringBuilder()
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Int>(Comparator<Int> { a, b ->
            val absCompare = abs(a) - abs(b)
            if (absCompare != 0) absCompare else a - b 
        }
    )

    repeat(N){
        val x = br.readLine().toInt()

        if(x!=0) {
            pq.add(x)
        } else {
            result.append(pq.poll() ?: 0).append("\n")
        }
    }
    print(result.toString())
}