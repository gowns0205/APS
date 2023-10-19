import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] dp;
	static int[][] A;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				// 왼쪽 끝
				if (j == 1) {
					dp[i][j] = dp[i - 1][j] + A[i][j];
				}
				// 오른쪽 끝
				else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + A[i][j];
				} 
				// 가운데
				else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + A[i][j];
				}
			}
		}
		int maxSum = -1;
		for (int i = 1; i <= n; i++) {
			if (maxSum < dp[n][i])
				maxSum = dp[n][i];
		}
		System.out.println(maxSum);
	}

}