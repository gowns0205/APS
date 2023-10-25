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
		DFS(0, 0);
		// 목표하는 합 S가 0인 경우, 공집합인 경우를 빼줘야 함 
		// 크기가 양수인 부분수열 구하는 것이기 때문
		cases = (S == 0) ? cases - 1 : cases;
		System.out.println(cases);
	}

	static void DFS(int depth, int sum) {
		if (depth == N) {
			if (sum == S)
				cases++;
			return;
		}
		// 트리에서 현재 노드를 선택하는 경우
		DFS(depth + 1, sum + A[depth]);
		// 선택하지 않고 건너뛰는 경우
		DFS(depth + 1, sum);
	}
}