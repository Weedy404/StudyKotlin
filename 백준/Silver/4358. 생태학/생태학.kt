import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.TreeMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val treeMap = TreeMap<String, Double>()
    var count = 0

    while (true) {
        val input = br.readLine() ?: break
        count++
        treeMap[input] = treeMap.getOrDefault(input, 0.0) + 1
    }

    val result = StringBuilder()
    for ((key, value) in treeMap) {
        val ratio = value / count * 100
        result.append("%s %.4f\n".format(key, ratio))
    }

    print(result.toString())
}
