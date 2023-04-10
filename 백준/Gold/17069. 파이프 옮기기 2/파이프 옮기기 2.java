import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static long[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		dp = new long[N][N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (c >= 2 && map[r][c] != 1)
					dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];
				if (r >= 2 && c >= 2 && map[r][c] != 1)
					dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];
				if (r >= 1 && c >= 2 && map[r][c] != 1 && map[r - 1][c] != 1 && map[r][c - 1] != 1)
					dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
			}
		}
		long result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		System.out.println(result);
	}

}