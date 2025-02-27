import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val testStack2 = LinkedList<Int>();
    val N = br.readLine().toInt();
    val result = StringBuilder();

    repeat(N) {
        val order = br.readLine().split(" ");

        when (order[0]) {
            "push" -> testStack2.addLast(order[1].toInt());
            "pop" -> result.append(if (testStack2.isEmpty()) "-1\n" else "${testStack2.pollLast()}\n");
            "size" -> result.append(testStack2.size).append("\n");
            "empty" -> result.append(if (testStack2.isEmpty()) "1\n" else "0\n");
            "top" -> result.append(testStack2.peekLast()?.toString() ?: "-1").append("\n");
        }

    }

    bw.write(result.toString());
    bw.flush();
    br.close();
    bw.close();
}