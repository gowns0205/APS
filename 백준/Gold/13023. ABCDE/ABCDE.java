import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean isExist = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			DFS(i, 1, visited);
			if (isExist)
				break;
		}
		if (isExist)
			System.out.println(1);
		else
			System.out.println(0);
	}

	static void DFS(int num, int depth, boolean[] visited) {
		if (depth == 5) {
			isExist = true;
			return;
		}
		visited[num] = true;
		for (int i : graph[num]) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(i, depth + 1, visited);
				visited[i] = false;
			}
		}
	}
}