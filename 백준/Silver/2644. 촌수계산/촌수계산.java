import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	static int A;
	static int B;
	static int depth = 0;
	static int result = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 노드 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine()); // 간선 개수
		edges = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		DFS(A, depth);
		System.out.println(result);
	}

	static void DFS(int cur, int depth) {
		visited[cur] = true;
		if (cur == B) {
			result = depth;
			return;
		}
		depth++;
		for (int next : edges[cur]) {
			if (!visited[next]) {
				DFS(next, depth);
			}
		}
	}
}