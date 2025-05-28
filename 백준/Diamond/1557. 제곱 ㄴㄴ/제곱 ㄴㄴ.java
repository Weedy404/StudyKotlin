import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] mu;
    static boolean[] visit;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        mu = new int[50000]; //1,000,000 * 2 의 root값 정도
        visit = new boolean[50000];
        Arrays.fill(mu, 1); //0: 제곱ㄴㄴ수 아님, 1: 제곱ㄴㄴ수 중 소인수가 짝수, -1: 홀수

        for (int i = 2; i < 50000; i++) {
            if (!visit[i]) {
                //i의 배수들 방문처리.(i로 이미 나눈 취급)
                for (int j = i; j < 50000; j += i) {
                    visit[j] = true;
                    mu[j] *= -1;
                }
                //제곱으로 나누어진 경우(제곱ㄴㄴ수가 아닌 수) 처리
                for (long j = 1L * i * i; j < 50000; j += i * i) {
                    mu[(int) j] = 0;
                }
            }
        }

        long high = 2L * K;
        long low = K;
        long mid = 0L;

        while (low <= high) {
            mid = (high + low) / 2L;
            long result = count(mid);

            if (result >= K) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
    }

    static long count(long mid) {
        long result = 0;

        //에라토스테네스의 체처럼 루트까지만 확인
        for (int i = 1; 1L * i * i <= mid; i++) {
            if (mu[i] != 0) {
                result += mu[i] * (mid / (1L * i * i));
            }
        }

        return result;
    }
}