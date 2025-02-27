import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val stack = LinkedList<Int>();
    val N = br.readLine().toInt();
    val result = StringBuilder();

    repeat(N) {
        val order = br.readLine().split(" ");

        when (order[0]) {
            "push" -> stack.addLast(order[1].toInt());
            "pop" -> result.append(if (stack.isEmpty()) "-1\n" else "${stack.pollLast()}\n");
            "size" -> result.append(stack.size).append("\n");
            "empty" -> result.append(if (stack.isEmpty()) "1\n" else "0\n");
            "top" -> result.append(stack.peekLast()?.toString() ?: "-1").append("\n");
        }

    }

    bw.write(result.toString());
    bw.flush();
    br.close();
    bw.close();
}