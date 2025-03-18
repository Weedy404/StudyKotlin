import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = StringBuilder()
    val T = br.readLine().toInt()

    repeat(T){
        val M = br.readLine().toInt()
        val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())
        val minHeap = PriorityQueue<Int>()
        var numCount = 0
        var printCount = 0
        result.appendLine((M+1)/2)

        repeat((M+9)/10){
            val nums = br.readLine().split(" ").map{it.toInt()}
            nums.forEach{ num ->
                numCount++
                maxHeap.add(num)

                if(minHeap.size < maxHeap.size) {
                  minHeap.add(maxHeap.poll())  
                }

                while(!maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()){
                    minHeap.add(maxHeap.poll())
                    maxHeap.add(minHeap.poll())
                }

                if(numCount%2 == 1){
                    result.append(minHeap.peek())
                    if(printCount==9){
                        result.append("\n")
                        printCount=0
                    }else{
                        result.append(" ")
                        printCount++
                    }
                }
            }
        }
        if(M%10 !=0){
            result.append("\n")
        }
    }
    print(result.toString())
}
