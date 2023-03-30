import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] dp;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		edges = new ArrayList[100001];
		for (int i = 0; i <= 100000; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		visited = new boolean[100001];
		dp = new int[100001];
		for (int i = 0; i <= 100000; i++) {
			if (i != 0)
				edges[i].add(i - 1);
			if(i<100000)
				edges[i].add(i + 1);
			if (i <= 50000)
				edges[i].add(i * 2);
		}
		dp[N] = 0;
		BFS(N);
		System.out.println(dp[K]);
	}

	private static void BFS(int n) {
		queue.add(n);
		visited[n] = true;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			if (num == K) {
				return;
			}
			for (int next : edges[num]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					dp[next] = dp[num] + 1;
				}
			}
		}

	}

}