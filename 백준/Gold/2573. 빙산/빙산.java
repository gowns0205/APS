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
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		int lump;
		while (true) {
			lump = 0; // 덩어리 개수
			visited = new boolean[N][M];
			// 빙산이 몇 덩어리인지 체크
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0 && !visited[r][c]) {
						BFS(r, c);
						lump++;
					}
				}
			}
			if (lump >= 2 || lump == 0)
				break;
			// 주위 0인 칸 개수만큼 빙산 녹이기
			int[][] count = new int[N][M];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != 0) {
						for (int d = 0; d < 4; d++) {
							int dr = r + dx[d];
							int dc = c + dy[d];
							if (map[dr][dc] == 0 && map[r][c] > 0)
								count[r][c]++;
						}
					}
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = Math.max(0, map[r][c] - count[r][c]);
				}
			}
			day++;
		}
		if (lump==0)
			System.out.println(0);
		else
			System.out.println(day);
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(r, c);
		queue.add(start);
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int d = 0; d < 4; d++) {
				int dr = cur.getR() + dx[d];
				int dc = cur.getC() + dy[d];
				if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1) {
					continue;
				}
				if (!visited[dr][dc] && map[dr][dc] > 0) {
					visited[dr][dc] = true;
					queue.add(new Node(dr, dc));
				}
			}
		}

	}

	static class Node {
		int r;
		int c;

		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}