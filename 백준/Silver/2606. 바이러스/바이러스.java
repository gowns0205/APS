import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];
		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int com = -1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			com++;
			for (int next : edges[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		System.out.println(com);
	}
}