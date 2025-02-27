import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val queue = LinkedList<Int>();
    val N = br.readLine().toInt();
    val result = StringBuilder();

    repeat(N) {
        val order = br.readLine().split(" ");

        when (order[0]) {
            "push" -> queue.addLast(order[1].toInt());
            "pop" -> result.append(if (queue.isEmpty()) "-1\n" else "${queue.pollLast()}\n");
            "size" -> result.append(queue.size).append("\n");
            "empty" -> result.append(if (queue.isEmpty()) "1\n" else "0\n");
            "top" -> result.append(queue.peekLast()?.toString() ?: "-1").append("\n");
        }

    }

    bw.write(result.toString());
    bw.flush();
    br.close();
    bw.close();
}