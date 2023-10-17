import java.util.*;
import java.io.*;

public class Main {
	static int[][] RGB;
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		findMinCost(0, -1, 0);
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (dp[N - 1][i] < minCost)
				minCost = dp[N - 1][i];
		}
		System.out.println(minCost);
	}

	static void findMinCost(int depth, int pre, int preCost) {
		if (depth == N)
			return;
		for (int i = 0; i < 3; i++) {
			int cost = preCost;
			if (i != pre) {
				cost = preCost + RGB[depth][i];
				if (dp[depth][i] == 0) {
					dp[depth][i] = cost;
					findMinCost(depth + 1, i, cost);
				}
				// 현재까지 비용이 최소값인 경우에만 다음 재귀 호출해야 시간초과 발생 X
				else if (cost < dp[depth][i]) {
					dp[depth][i] = cost;
					findMinCost(depth + 1, i, cost);
				}
			}
		}
	}
}