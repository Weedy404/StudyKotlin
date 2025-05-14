import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf(0)
    list.addAll(input)

    //뒤에서 앞으로 검사
    fun toFront() {
        val sb = StringBuilder()
        var count=0
        val newList = list.toMutableList()
        for(i in N downTo 1) {
            if(newList[i] != i) {

                for(j in i downTo 1){
                    if(newList[j] == i){
                        count ++
                        sb.append(j).append(" ").append(i)
                        newList.subList(j, i+1).reverse()
                        if(count==1) sb.append("\n")        
                        break
                    }
                }

                if(count>=3) break
            }
        }
        if(count == 2) {
            print(sb.toString())
        } else if(count == 1) {
            sb.append(1).append(" ").append(1)
            print(sb.toString())
        } else if (count==0) {
            sb.append(1).append(" ").append(1).append("\n")
            sb.append(1).append(" ").append(1)
            print(sb.toString())
        }
    }


    //앞에서 뒤로 검사
    fun toBack() {
        val sb = StringBuilder()
        var count=0
        val newList = list.toMutableList()
        for(i in 1..N) {
            if(newList[i] != i) {

                for(j in i..N){
                    if(newList[j] == i){
                        count ++
                        sb.append(i).append(" ").append(j)
                        newList.subList(i, j+1).reverse()
                        if(count==1) sb.append("\n")        
                        break
                    }
                }

                if(count>=3) break
            }
        }
        if(count >= 3){
            toFront()
            return
        } else if(count == 2) {
            print(sb.toString())
        } else if(count == 1) {
            sb.append(1).append(" ").append(1)
            print(sb.toString())
        } else if (count==0) {
            sb.append(1).append(" ").append(1).append("\n")
            sb.append(1).append(" ").append(1)
            print(sb.toString())
        }
    }

    toBack()
}
