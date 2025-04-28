import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val rev = str.reversed()
    if(str == rev) {
        var judge = str.all{it == rev[0]}
        if(judge) {
            print(-1)
        } else {
            print(str.length-1)
        }
    } else {
        print(str.length)
    }
}