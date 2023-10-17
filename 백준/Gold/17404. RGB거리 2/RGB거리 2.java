import java.util.*;
import java.io.*;

public class Main {
	static int[][] RGB;
	static int N;
	static int[][][] dp; // 마지막 차원은 첫 번째 집 색깔

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		dp = new int[N][3][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		for (int firstColor = 0; firstColor < 3; firstColor++) {
			findMinCost(0, -1, 0, firstColor);
		}
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (dp[N - 1][i][j] < minCost && dp[N - 1][i][j] != 0)
					minCost = dp[N - 1][i][j];
			}
		}
		System.out.println(minCost);
	}

	static void findMinCost(int depth, int pre, int preCost, int firstColor) {
		if (depth == N)
			return;
		if (depth == 0) {
			dp[depth][firstColor][firstColor] = RGB[depth][firstColor];
			findMinCost(depth + 1, firstColor, RGB[depth][firstColor], firstColor);
			return;
		}
		for (int i = 0; i < 3; i++) {
			int cost = preCost + RGB[depth][i];
			if (i != pre) {
				if (depth == N - 1 && i == firstColor)
					continue;
				if (dp[depth][i][firstColor] == 0) {
					dp[depth][i][firstColor] = cost;
					findMinCost(depth + 1, i, cost, firstColor);
				}
				if (cost < dp[depth][i][firstColor]) {
					dp[depth][i][firstColor] = cost;
					findMinCost(depth + 1, i, cost, firstColor);
				}
			}
		}
	}
}