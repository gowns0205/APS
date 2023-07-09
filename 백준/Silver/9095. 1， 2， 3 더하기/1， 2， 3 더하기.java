import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀
public class Main {
	static int cnt;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			plus(0);
			sb.append(cnt + "\n");
		}
		System.out.println(sb);

	}

	public static void plus(int cur) {
		if (cur == n) {
			cnt++;
			return;
		} else if (cur > n) {
			return;
		}
		int tmp = cur;
		plus(tmp + 1);
		plus(tmp + 2);
		plus(tmp + 3);
	}
	
}