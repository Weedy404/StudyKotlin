import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    val result = StringBuilder()
    repeat(T) {
        val K = br.readLine().toInt()
        val map = TreeMap<Int, Int>()

        repeat(K) {
            val (order, numString) = br.readLine().split(" ")
            val num = numString.toInt()

            when (order) {
                "I" -> map[num] = map.getOrDefault(num, 0) + 1
                "D" -> {
                    if (map.isNotEmpty()) {
                        val key = if (num == 1) map.lastKey() else map.firstKey()
                        if (map[key] == 1) map.remove(key) else map[key] = map[key]!! - 1
                    }
                }
            }
        }

        if (map.isEmpty()) {
            result.appendLine("EMPTY")
        } else {
            result.appendLine("${map.lastKey()} ${map.firstKey()}")
        }
    }
    print(result)
}
