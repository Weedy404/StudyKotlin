import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val deque = LinkedList<Int>();
    val N = br.readLine().toInt();
    val result = StringBuilder();

    repeat(N) {
        val order = br.readLine().split(" ");

        when (order[0]) {
            "push" -> deque.addLast(order[1].toInt());
            "pop" -> result.append(if (deque.isEmpty()) "-1\n" else "${deque.pollFirst()}\n");
            "size" -> result.append(deque.size).append("\n");
            "empty" -> result.append(if (deque.isEmpty()) "1\n" else "0\n");
            "front" -> result.append(deque.peekFirst()?.toString() ?: "-1").append("\n");
            "back" -> result.append(deque.peekLast()?.toString() ?: "-1").append("\n");
        }
    }

    bw.write(result.toString());
    bw.flush();
    br.close();
    bw.close();
}
