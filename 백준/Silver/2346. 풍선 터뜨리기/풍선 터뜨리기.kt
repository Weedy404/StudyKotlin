import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

val balloons = ArrayDeque<IntArray>()

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val values = br.readLine().split(" ").map{ it.toInt() }
    val result = mutableListOf<Int>();
    var order = 0

    repeat(N){ i ->
        val pair = intArrayOf(i+1, values[i])
        balloons.addLast(pair)
    }

    while(!balloons.isEmpty()){
        val nextBalloon = balloons.removeFirst()
        result.add(nextBalloon[0])
        
        if(!balloons.isEmpty()){
            move(nextBalloon[1])
        }
    }

    print(result.joinToString(" "))
}

fun move(value : Int){
    if (value > 0){
        repeat(value-1){
            balloons.addLast(balloons.removeFirst())
        }
    } else if (value < 0){
        repeat(-value){
            balloons.addFirst(balloons.removeLast())
        }
    }
}