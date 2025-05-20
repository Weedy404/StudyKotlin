import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val L = br.readLine().toInt()
    val input = br.readLine()
    val pi = IntArray(L)

    fun makePi() {
        var i=1
        var j=0
        pi[0] = 0

        while(i < input.length){
            while(input[i] != input[j] && j > 0) j = pi[j-1]
            
            if (input[i] == input[j]) {
                pi[i] = j+1
                j++
            } else {
                pi[i] = 0
            }

            i++
        }
    }

    makePi()

    print(input.length - pi[input.length -1])

}