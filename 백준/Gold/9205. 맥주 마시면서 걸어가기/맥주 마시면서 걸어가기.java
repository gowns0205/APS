import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static boolean result;
	static Node lastNode;
	static ArrayList<Node> nodeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new ArrayList[n + 2];
			visited = new boolean[n + 2];
			for (int i = 0; i < n + 2; i++) {
				graph[i] = new ArrayList<>();
			}
			nodeList = new ArrayList<>();
			for (int i=0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Node cur = new Node(x, y, i);
				nodeList.add(cur);
				if (i > 0) {
					for (int j = 0; j < nodeList.size(); j++) {
						Node tmp = nodeList.get(j);
						int m_distance = Math.abs(cur.x - tmp.x) + Math.abs(cur.y - tmp.y);
						if (m_distance <= 1000) {
							graph[cur.idx].add(tmp);
							graph[tmp.idx].add(cur);
						}
					}
				}
			}
			result = false;
			DFS(nodeList.get(0).idx);
			if (result)
				sb.append("happy" + "\n");
			else
				sb.append("sad" + "\n");
		}
		System.out.println(sb);
	}

	private static void DFS(int cur) {
		visited[cur] = true;
		if (nodeList.get(cur).idx == n + 1) {
			result = true;
			return;
		}
		for (Node next : graph[cur]) {
			if (!visited[next.idx])
				DFS(next.idx);
		}
	}

	static class Node {
		int x;
		int y;
		int idx;

		public Node(int x, int y, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}
}