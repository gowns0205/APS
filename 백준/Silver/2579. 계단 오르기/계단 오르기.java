import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] stair;
	static int[] dp;
	static int N;
	static int score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stair = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(upStair());
	}

	public static int upStair() {
		dp[1] = stair[1];
		if (N >= 2) {
			dp[2] = stair[1] + stair[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
		}
		return dp[N];
	}
}