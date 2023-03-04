import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			for (int r = r1; r < r1 + r2; r++) {
				for (int c = c1; c < c1 + c2; c++) {
					arr[r][c] = i;
				}
			}

		}
		int[] cntArr = new int[N + 1];
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				//System.out.print(arr[i][j] + " ");
				for (int k = 1; k <= N; k++) {
					if (arr[i][j] == k)
						cntArr[k]++;
				}

			}
			//System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(cntArr[i]);
		}
	}
}