import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w, h) = br.readLine().split(" ").map{it.toInt()}
    val (p, q) = br.readLine().split(" ").map{it.toInt()}
    val t = br.readLine().toInt()

    fun calc(start:Int, max:Int, time:Int): Int {
        val remainTime = time%(2*max)
        if (remainTime <= max - start) {
            return remainTime + start
        } else if (remainTime <= 2*max - start) {
            return 2*max - remainTime - start
        } else {
            return remainTime - (2*max) + start
        }
    }

    val x = calc(p, w, t)
    val y = calc(q, h, t)
    print("$x $y")
}