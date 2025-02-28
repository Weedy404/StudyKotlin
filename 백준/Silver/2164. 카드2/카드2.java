import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> card = new LinkedList<>();
		
		for(int i =1; i<=N; i++) {
			card.offer(i);
		}
		int temp=1;
		
		while(card.size()>1) {
			card.poll();
			temp = card.poll();
			card.offer(temp);
		}
		
		bw.write(String.valueOf(temp));
		bw.newLine();
		bw.flush();

		br.close();
		bw.close();
	}
}