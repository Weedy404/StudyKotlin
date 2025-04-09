import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.Queue
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val graph = Array(N+1) { mutableListOf<Int>() }
    val parent = IntArray(N+1)
    val visit = BooleanArray(N+1)

    for(i in 1 until N) {
        val st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }

    //bfs 활용
    val queue: Queue<Int> = LinkedList()
    queue.add(1)            //정점부터 시작
    visit[1] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (i in graph[current]) {
            if (!visit[i]) {
                //정점부터 내려오므로, 방문한 적이 없다면 부모가 됨
                visit[i] = true
                parent[i] = current 
                queue.add(i)
            }
        }
    }

    for(i in 2..N){
        println(parent[i])
    }
}