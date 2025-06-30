import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<String> hs = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		hs.add("ChongChong");
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			if(hs.contains(input[0])) {
				hs.add(input[1]);
			}else if(hs.contains(input[1])) {
				hs.add(input[0]);
			}
		}
		
		bw.write(String.valueOf(hs.size()));
		bw.newLine();
		bw.flush();

		br.close();
		bw.close();
	}
}