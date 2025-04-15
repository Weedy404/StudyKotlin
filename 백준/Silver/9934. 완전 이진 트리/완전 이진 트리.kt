import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val K = br.readLine().toInt()
    val array = Array(K) { mutableListOf<Int>() }
    val input = br.readLine().split(" ").map{it.toInt()}
    val result = StringBuilder()

    fun rec(left:Int, right:Int, depth:Int) {
        val center = (left+right)/2
        array[depth].add(input[center])

        if(left == right) return

        rec(left, center-1, depth+1)
        rec(center+1, right, depth+1)
    }

    rec(0, input.size-1, 0)

    for(i in array.indices){
        val output = array[i].joinToString(" ")
        result.appendLine(output)
    }
    print(result.toString())
}