import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Queue<Node> queue = new LinkedList<>();
	static boolean[][] visited;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] dp; // 출발 지점부터의 거리
	static int[][] maze;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		BFS(0, 0);
		System.out.println(dp[N - 1][M - 1]);
	}

	static void BFS(int r, int c) {
		queue.add(new Node(r, c)); // 시작 노드
		visited[r][c] = true; // 방문 처리

		while (!queue.isEmpty()) {
			Node x = queue.poll();
			r = x.r;
			c = x.c;
			for (int i = 0; i < 4; i++) {
				int dr = r + dy[i];
				int dc = c + dx[i];
				if (dr > -1 && dr < N && dc > -1 && dc < M) {
					if (!visited[dr][dc] && maze[dr][dc] == 1) {
						queue.add(new Node(dr, dc));
						dp[dr][dc] = dp[r][c] + 1; // 다음 노드 거리 = 현재 노드 거리 + 1
						visited[dr][dc] = true;
					}
				}
			}
		}
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

}