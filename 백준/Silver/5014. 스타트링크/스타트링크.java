import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
	static int[] dp;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static int G;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		edges = new ArrayList[F + 1];
		dp = new int[F + 1];
		visited = new boolean[F + 1];
		for (int i = 1; i <= F; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 1; i <= F; i++) {
			if (i - D >= 1)
				edges[i].add(i - D);
			if (i + U <= F)
				edges[i].add(i + U);
		}
		dp[S] = 0;
		BFS(S);
		if (S != G && dp[G] == 0)
			System.out.println("use the stairs");
		else
			System.out.println(dp[G]);
	}

	private static void BFS(int s) {
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int curFloor = queue.poll();
			if (curFloor == G)
				return;
			for (int nextFloor : edges[curFloor]) {
				if (!visited[nextFloor]) {
					visited[nextFloor] = true;
					queue.add(nextFloor);
					dp[nextFloor] = dp[curFloor] + 1;
				}
			}
		}
	}
}