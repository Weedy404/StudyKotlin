import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()
    val result = StringBuilder()
    
    for(i in 1..T){
        val N = br.readLine().toInt()
        when(N) {
            1,2,3,6 -> println(0)
            4 -> println(2)
            else -> println(1)
        }
    }
}
