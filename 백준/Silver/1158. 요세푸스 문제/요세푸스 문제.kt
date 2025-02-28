import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val (N, K) = br.readLine().split(" ").map { it.toInt() };
    val deque = ArrayDeque((1..N).toList());
    val result = mutableListOf<Int>();
    
    repeat(N){
        repeat(K-1){
            deque.addLast(deque.removeFirst());
        }
        result.add(deque.removeFirst());
    }

    bw.write(result.joinToString(", ", "<", ">"));
    bw.flush();
    br.close();
    bw.close();
}