import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if(n==1 || n==3){
        print(-1)
    }else{
        var (count, remainder) = n/5 to n%5     //to : pair로 만들어줌
        count += (if (remainder%2 != 1) remainder/2 else remainder/2 + 2)
        print(count)
    }
}