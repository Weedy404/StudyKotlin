import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map{it.toInt()}
    val arr = IntArray(N+1) {it}
    val visit = BooleanArray(N+1)
    val result = StringBuilder()
    var judge = true

    for(i in 1..M) {
        val (x, y) = br.readLine().split(" ").map{it.toInt()}
        arr[x]++
        arr[y]--
    }

    for(i in 1..N) {
        if(visit[arr[i]]){
            judge = false
            break
        } else {
            visit[arr[i]] = true
            result.append(arr[i]).append(" ")
        }
    }
    
    if(judge) {
        print(result.toString())
    } else {
        print (-1)
    }
}
