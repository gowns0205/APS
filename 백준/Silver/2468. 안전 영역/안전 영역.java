import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] result;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int maxHeight = 0;
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > maxHeight)
					maxHeight = map[r][c];
			}
		}
		int maxCnt = 0;
		for (int h = 0; h < maxHeight; h++) {
			result = new int[N][N];
			visited = new boolean[N][N];
			int tmpCnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > h) {
						result[r][c] = 1;
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c] && result[r][c] == 1) {
						BFS(r, c);
						tmpCnt++;
					}
				}
			}
			if (tmpCnt > maxCnt)
				maxCnt = tmpCnt;
		}
		System.out.println(maxCnt);
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(r, c);
		queue.add(start);
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curR = cur.getR();
			int curC = cur.getC();
			for (int d = 0; d < 4; d++) {
				int dr = curR + dy[d];
				int dc = curC + dx[d];
				if (dr < 0 || dr > N - 1 || dc < 0 || dc > N - 1) {
					continue;
				}
				if (!visited[dr][dc] && result[dr][dc] == 1) {
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