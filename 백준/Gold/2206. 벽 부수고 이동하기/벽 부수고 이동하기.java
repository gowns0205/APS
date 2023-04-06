import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N;
	static int M;
	static boolean[][][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int r = 0; r < N; r++) {
			String s = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}
		BFS(0, 0);
		System.out.println(result);
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c, 0, 1));
		visited[r][c][0] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.r == N - 1 && cur.c == M - 1) {
				result = cur.depth;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int dr = cur.r + dx[d];
				int dc = cur.c + dy[d];
				if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1)
					continue;
				if (!visited[dr][dc][cur.crush] && map[dr][dc] == 0) {
					visited[dr][dc][cur.crush] = true;
					queue.add(new Node(dr, dc, cur.crush, cur.depth + 1));
				} else if (!visited[dr][dc][1] && map[dr][dc] == 1 && cur.crush == 0) {
					visited[dr][dc][cur.crush + 1] = true;
					queue.add(new Node(dr, dc, cur.crush + 1, cur.depth + 1));
				}
			}
		}
	}

	static class Node {
		int r;
		int c;
		int crush;
		int depth;

		public Node(int r, int c, int crush, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.crush = crush;
			this.depth = depth;
		}
	}

}