import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] T, P;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		recur(1, 0);
		int max = -1;
		for (int d = 1; d <= N; d++) {
			if (dp[d] > max)
//			System.out.println("날짜: " + d + " 수익: " + dp[d]);
				max = dp[d];
		}
		System.out.println(max);
	}

	static void recur(int cur, int profit) {
		if (cur > N + 1)
			return;
		dp[cur - 1] = Math.max(dp[cur - 1], profit);
		if (cur > N)
			return;
		recur(cur + T[cur], profit + P[cur]);
		recur(cur + 1, profit);
	}
}