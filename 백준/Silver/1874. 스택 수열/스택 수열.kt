import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    val n = readLine()!!.toInt()
    val sb = StringBuilder()
    var count = 1
    var valid = true

    for (i in 0 until n) {
        val targetNumber = readLine()!!.toInt()

        while (count <= targetNumber) {
            stack.push(count++)
            sb.appendLine("+")
        }

        if (stack.peek() == targetNumber) {
            stack.pop()
            sb.appendLine("-")
        } else { 
            valid = false
        }
    }

    if (valid) {
        print(sb.toString())
    } else {
        println("NO")
    }
}
