import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val ts = TreeSet<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
    val map = mutableMapOf<Int, Int>()

    repeat(N) {
        val (P, L) = br.readLine().split(" ").map { it.toInt() }
        ts.add(P to L)
        map[P] = L
    }

    val M = br.readLine().toInt()
    repeat(M) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "add" -> {
                val P = input[1].toInt()
                val L = input[2].toInt()
                ts.add(P to L)
                map[P] = L
            }
            "recommend" -> {
                val num = input[1].toInt()
                if (num == 1) {
                    println(ts.last().first)
                } else if (num == -1) {
                    println(ts.first().first)
                }
            }
            "solved" -> {
                val P = input[1].toInt()
                val L = map[P]!!
                ts.remove(P to L)
            }
        }
    }
}
