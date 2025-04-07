import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var count = 1

    while (true) {
        val map = mutableMapOf<Int, Int>()
        val vertex = mutableSetOf<Int>()
        var flag = false
        var st = StringTokenizer(br.readLine())
        var u = 0
        var v = 0

        outer@ while (true) {
            while (!st.hasMoreTokens()) {
                st = StringTokenizer(br.readLine())
            }

            u = st.nextToken().toInt()
            v = st.nextToken().toInt()

            if (u == 0) break
            if (u == -1) break@outer

            if (!vertex.add(v)) {
                flag = true
            }
            map[u] = map.getOrDefault(u, 0) + 1
        }

        if (u == -1) break

        if (vertex.isNotEmpty()) {
            var rootCount = 0
            for (node in map.keys) {
                if (node !in vertex) rootCount++
            }
            if (rootCount != 1) flag = true
        }

        if (flag) {
            sb.append("Case $count is not a tree.\n")
        } else {
            sb.append("Case $count is a tree.\n")
        }

        count++
    }

    println(sb.toString())
}
