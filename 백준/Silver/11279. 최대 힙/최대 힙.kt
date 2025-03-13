import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pq = PriorityQueue<Int>(Comparator.reverseOrder())
    val N = br.readLine().toInt()
    val result = StringBuilder()

    repeat(N){
        val input = br.readLine().toInt()
        if(input == 0){
            val num = if (pq.isEmpty()) 0 else pq.poll()
            result.appendLine(num)
        }else{
            pq.add(input)
        }
    }

    print(result.toString())
}
