import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			inDegree[B]++;
		}
		Queue<subject> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(new subject(i, 1));
			}
		}
		int[] result = new int[N + 1];
		while (!queue.isEmpty()) {
			subject cur = queue.poll();
			int n = cur.n;
			int sem = cur.semester;
			result[n] = sem;
			for (int next : graph[n]) {
				inDegree[next]--;
				if (inDegree[next] == 0)
					queue.add(new subject(next, sem + 1));
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb);
	}

	static class subject {
		int n;
		int semester;

		public subject(int n, int semester) {
			super();
			this.n = n;
			this.semester = semester;
		}
	}
}