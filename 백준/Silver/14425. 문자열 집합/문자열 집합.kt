import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = hashSetOf<String>()
    val (N, M) = br.readLine().split(" ").map{ it.toInt() }
    var count = 0

    repeat(N){
        set.add(br.readLine())
    }

    repeat(M){
        if(set.contains(br.readLine())){
            count++
        }
    }
    print(count)
}
