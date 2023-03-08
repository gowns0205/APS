import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//하노이탑 최소 이동 횟수: 2^N - 1 
		int K = (int) (Math.pow(2, N) - 1);
		sb.append(K).append('\n');
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	static void hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			sb.append(start + " ").append(to).append('\n');
			return;
		}
		hanoi(N - 1, start, to, mid);

		sb.append(start + " ").append(to + "\n");

		hanoi(N - 1, mid, start, to);
	}
}