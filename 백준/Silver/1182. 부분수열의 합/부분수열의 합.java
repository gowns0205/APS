import java.util.*;
import java.io.*;

public class Main {
	static int[] A;
	static int N, S, cases;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		A = new int[N];
		cases = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		boolean[] visited = new boolean[N];
		combination(0, 0, visited, 0);
		System.out.println(cases);
	}

	static void combination(int depth, int start, boolean[] visited, int sum) {
		if (depth == N) {
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int curSum = 0;
				curSum += sum;
				curSum += A[i];
				if (curSum == S)
					cases++;
//				System.out.println(A[i] + " , " + curSum + " , " + S);
				combination(depth + 1, i + 1, visited, curSum);
				visited[i] = false;
			}
		}
	}
}