import java.util.*;
import java.io.*;

public class Main {
	static int N, max;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] visited = new boolean[N];
		DFS(0, 0, 0, visited);
		System.out.println(max);
	}

	static void DFS(int depth, int pre, int sum, boolean[] visited) {
		if (depth == N) {
//			System.out.println(depth + " , "+ sum);
			if (sum > max)
				max = sum;
			return;
		}

		if (depth == 0) {
			for (int i = 0; i < N; i++) {
				visited[i] = true;
				DFS(depth + 1, A[i], 0, visited);
				visited[i] = false;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(depth + 1, A[i], sum + Math.abs(pre - A[i]), visited);
				visited[i] = false;
			}
		}
	}
}