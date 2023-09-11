import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;

	static int connectedComponent = 0;

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[1001];
		visited = new boolean[1001];
		boolean[] edgeList = new boolean[1001];
		for (int i = 1; i <= 1000; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edgeList[u] = true;
			edgeList[v] = true;
			graph[u].add(v);
			graph[v].add(u);
		}
		for (int i = 1; i <= 1000; i++) {
			if (graph[i].isEmpty() || visited[i])
				continue;
			else {
				connectedComponent++;
				DFS(i);
			}
		}
		int edgeCount = 0;
		for (int i = 1; i <= 1000; i++) {
			if (edgeList[i])
				edgeCount++;

		}
		// 간선으로 연결되어 있지 않은 정점은 각각을 연결요소로 봐야 한다.
		connectedComponent += N - edgeCount;
		System.out.println(connectedComponent);
	}

	private static void DFS(int num) {
		visited[num] = true;
		for (int i = 0; i < graph[num].size(); i++) {
			int cur = graph[num].get(i);
			if (!visited[cur]) {
				DFS(cur);
			}
		}
	}
}