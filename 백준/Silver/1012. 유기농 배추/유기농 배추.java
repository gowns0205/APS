import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[Y][X] = 1;
			}
			visited = new boolean[N][M];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 1 && !visited[r][c]) {
						BFS(r, c);
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	public static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(r, c);
		queue.add(start);
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dr = cur.r + dx[i];
				int dc = cur.c + dy[i];
				if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1)
					continue;
				if (arr[dr][dc] == 1 && !visited[dr][dc]) {
					visited[dr][dc] = true;
					queue.add(new Node(dr, dc));
				}
			}
		}
	}

	public static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}