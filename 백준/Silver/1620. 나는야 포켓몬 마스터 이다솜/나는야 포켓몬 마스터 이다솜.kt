fun main() {
    val stringKeyMap = HashMap<String,Int>()
    val numKeyMap = HashMap<Int,String>()
    val (N, M) = readLine()?.split(" ")?.map{ it.toInt() } ?: listOf(0,0)
    val sb = StringBuilder()
    
    for(i in 1..N){
        val name = readLine()
        name?.let{ 
            stringKeyMap[name] = i 
            numKeyMap[i] = name 
        }
    }

    for(i in 1..M){
        val input = readLine()
        val result = input?.toIntOrNull()?.let { numKeyMap[it] } ?: stringKeyMap[input]
        sb.appendLine(result)
    }

    print(sb.toString())
}
