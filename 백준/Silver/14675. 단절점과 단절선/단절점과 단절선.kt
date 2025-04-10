import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val nodes = IntArray(n+1)
    val result = StringBuilder()

    for(i in 1 until n) {
        val st = StringTokenizer(br.readLine())
        nodes[st.nextToken().toInt()]++
        nodes[st.nextToken().toInt()]++
    }

    val q = br.readLine().toInt()

    for(i in 1..q) {
        val st = StringTokenizer(br.readLine())
        val question = st.nextToken()
        if(question == "1") {
            val nodeNum = st.nextToken().toInt()
            if(nodes[nodeNum] > 1) {
                result.appendLine("yes")
            } else {
                result.appendLine("no")
            }
        } else {
            result.appendLine("yes")
        }
    }
    print(result.toString())
}