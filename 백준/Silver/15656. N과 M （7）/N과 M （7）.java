import java.util.*;
import java.io.*;

// 중복순열 문제 
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
		int[] out = new int[M];
		permutation(num, visited, M, 0, out);
		System.out.println(sb);
		br.close();
	}

	static void permutation(int[] num, boolean[] visited, int r, int depth, int[] out) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(out[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			out[depth] = num[i];
			permutation(num, visited, r, depth + 1, out);
		}
	}
}