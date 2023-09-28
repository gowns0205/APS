import java.util.*;
import java.io.*;

// 아이디어: 임의의 노드에서 가장 긴 경로로 연결돼 있는 노드는 트리의 지름에 해당하는 두 노드중 하나다. 
public class Main {
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine()); // 트리 정점 개수
		tree = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			while (true) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1)
					break;
				int dis = Integer.parseInt(st.nextToken());
				tree[u].add(new Node(v, dis));
			}
		}
		visited = new boolean[V + 1];
		dp = new long[V + 1];
		BFS(1);
		int diaNode = 0; // 트리의 지름에 해당하는 두 노드 중 하나
		long max = -1;
		for (int i = 1; i <= V; i++) {
			if (dp[i] > max) {
				max = dp[i];
				diaNode = i;
			}
		}
		visited = new boolean[V + 1];
		dp = new long[V + 1];
		BFS(diaNode);
		long diameter = -1;
		for (int i = 1; i <= V; i++) {
			if (dp[i] > diameter) {
				diameter = dp[i];
			}
		}
		System.out.println(diameter);
	}

	static void BFS(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		visited[start] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (Node next : tree[cur.v]) {
				if (!visited[next.v]) {
					visited[next.v] = true;
					dp[next.v] = dp[cur.v] + next.dis;
					queue.add(next);
				}
			}
		}
	}

	static class Node {
		int v;
		int dis;

		Node(int v, int dis) {
			super();
			this.v = v;
			this.dis = dis;
		}
	}
}