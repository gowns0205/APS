import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int bag5 = 0;
		int bag3 = 0;
		int cnt = 0;
		int idx = 0;
		point: while (idx <= N / 3) {
			bag5 = Math.max(N / 5 - idx, 0);
			for (int i = 0; i <= N / 3; i++) {
				bag3 = i;
				if (bag5 * 5 + bag3 * 3 == N) {
					cnt++;
					break point;
				}
			}
			idx++;
		}
		if (cnt == 0)
			System.out.println(-1);
		else
			System.out.println(bag5 + bag3);
	}
}