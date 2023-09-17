import java.util.*;
import java.io.*;

// 조합 문제 
public class Main {

	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		combinatation(num, visited, M, 0,1);
		System.out.println(sb);
		br.close();
	}

	static void combinatation(int[] num, boolean[] visited, int r, int depth, int start) {
		if (depth == r) {
			for (int i = 1; i <= N; i++) {
				if (visited[i])
					sb.append(num[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combinatation(num, visited, r, depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}