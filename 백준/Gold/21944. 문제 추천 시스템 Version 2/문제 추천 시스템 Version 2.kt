import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.TreeSet
import java.util.TreeMap

data class Problem(val num: Int, val dif: Int) : Comparable<Problem> {
    override fun compareTo(other: Problem) = if (dif == other.dif) other.num - num else other.dif - dif
    override fun toString() = "$num"
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val result = StringBuilder()

    val dif = IntArray(100001)
    val alg = IntArray(100001)
    val algArray = Array(101) { TreeSet<Problem>() }
    val problems = TreeSet<Problem>()

    fun addProblem( P : Int, L : Int, G : Int ) {
        val newProblem = Problem(P, L)
        dif[P] = L
        alg[P] = G
        algArray[G].add(newProblem)
        problems.add(newProblem)
    }

    repeat(N){
        val (P, L, G) = br.readLine().split(" ").map{ it.toInt() }
        addProblem(P, L, G)
    }

    val M = br.readLine().toInt()

    repeat(M){
        val order = br.readLine().split(" ")
        when(order[0]) {
            "recommend" -> {
                val picked = algArray[order[1].toInt()]
                result.appendLine( if (order[2] == "1") "${picked.first()}" else "${picked.last()}" )
            }
            "recommend2" -> {
                result.appendLine( if (order[1] == "1") "${problems.first()}" else "${problems.last()}" )
            }
            "recommend3" -> {
                val L = order[1]
                val dummy = Problem(0, order[2].toInt())
                result.appendLine( if(L == "1") "${problems.floor(dummy)?:-1}" else "${problems.ceiling(dummy)?:-1}")
            }
            "add" -> { 
                val P = order[1].toInt()
                val L = order[2].toInt()
                val G = order[3].toInt()
                addProblem(P, L, G)
            }
            "solved" -> {
                val P = order[1].toInt()
                val problem = Problem(P, dif[P])
                algArray[alg[P]].remove(problem)
                problems.remove(problem)
            }
        }
    }
    print(result.toString())
}