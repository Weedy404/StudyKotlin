import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val result = StringBuilder()

    result.appendLine(2000)
    for(i in 1 until 2000){
        if(i<=1000){
            result.append(1).append(" ")
        } else {
            result.append(1000).append(" ")
        }
    }
    result.append(1000)
    print(result.toString())
}