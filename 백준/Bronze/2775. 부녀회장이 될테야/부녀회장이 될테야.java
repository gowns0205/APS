import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apart = new int[k + 1][n + 1];
			for (int i = 0; i <= k; i++) {
				if (i == 0) {
					for (int j = 1; j <= n; j++) {
						apart[i][j] = j;
					}
				} else {
					for (int j = 1; j <= n; j++) {
						for (int g = 1; g <= j; g++) {
							apart[i][j] += apart[i - 1][g];
						}
					}
				}
			}
			sb.append(apart[k][n]+"\n");
		}
		System.out.println(sb);
	}
}