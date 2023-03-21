import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] edges;
	static int[] answer;
	static int idx = 1;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		edges = new ArrayList[N + 1];
		answer = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(edges[i]);
		}
		dfs(V);
		sb.append("\n");
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		Arrays.fill(visited, false);
		visited[V] = true;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur + " ");
			for (int next : edges[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		System.out.println(sb);
	}

	static void dfs(int cur) {
		visited[cur] = true;
		sb.append(cur + " ");
		for (int next : edges[cur]) {
			if (!visited[next])
				dfs(next);
		}
	}
}