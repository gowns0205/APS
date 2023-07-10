import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		fillTile(n - 1);
		System.out.println(dp[n - 1]);
		br.close();
	}

	public static int fillTile(int cur) {
		// Base
		if (cur == 0) {
			dp[0] = 1;
			return 1;
		} else if (cur == 1) {
			dp[1] = 2;
			return 2;
		}

		if (dp[cur] != 0) {
			return dp[cur];
		}
		// 막혔던 이유 
		// 바로 10007의 나머지로 처리하면서 더하지 않으면 long 숫자 범위도 초과해버린다. 
		dp[cur] = (fillTile(cur - 1) + fillTile(cur - 2))%10007;
		return dp[cur];
	}
}