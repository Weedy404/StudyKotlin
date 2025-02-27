import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val bw = BufferedWriter(OutputStreamWriter(System.out));
    val T = br.readLine().toInt();
    val result = StringBuilder();

    repeat(T) {
        val testCase = br.readLine().toCharArray();
        val stack = ArrayDeque<Char>();

        for(i in 0 until testCase.size){
            val nextChar = testCase[i];

            if(nextChar == '('){
                stack.addLast(nextChar);
            }else{
                if(stack.lastOrNull() == '('){
                    stack.removeLastOrNull();
                }else{
                    stack.addLast(nextChar);
                }
            }
        }
        if(stack.size == 0){
            result.append("YES").append("\n");
        }else{
            result.append("NO").append("\n");
        }
    }

    bw.write(result.toString());
    bw.flush();
    br.close();
    bw.close();
}