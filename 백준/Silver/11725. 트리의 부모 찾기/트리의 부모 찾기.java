import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		DFS(1, -1);
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb);
	}

	static void DFS(int cur, int pre) {
		if(parent[cur]==0)
			parent[cur] = pre;
		for(int i:graph[cur]) {
			if(i!=pre)
				DFS(i,cur);
		}
	}
}