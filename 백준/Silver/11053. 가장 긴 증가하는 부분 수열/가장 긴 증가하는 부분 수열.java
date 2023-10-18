import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			int maxLenIdx = 0;
			for (int j = 1; j < i; j++) {
				if (A[j] < A[i] && dp[maxLenIdx] < dp[j]) {
					maxLenIdx = j;
				}
			}
			dp[i] = dp[maxLenIdx] + 1;
		}
		int maxLen = -1;
		for (int d : dp) {
			if (maxLen < d)
				maxLen = d;
		}
		System.out.println(maxLen);
	}
}