import java.util.*;
import java.io.*;

// 중복조합 문제 
// StringBuilder 안 쓰면 시간초과 발생
public class Main {

	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] out = new int[M];
		combination(out, M, 0, 1);
		System.out.println(sb);
		br.close();
	}

	static void combination(int[] out, int m, int depth, int start) {
		if (depth == m) {
			for (int i = 0; i < m; i++)
				sb.append(out[i] + " ");
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			out[depth] = i;
			combination(out, m, depth + 1, i);
		}
	}
}