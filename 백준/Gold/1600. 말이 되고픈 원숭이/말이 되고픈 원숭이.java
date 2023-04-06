import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int H;
	static int W;
	static int K;
	static boolean[][][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int cntH;
	static int result = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		visited = new boolean[K + 1][H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		BFS(0, 0);
		if (H == 1 && W == 1)
			System.out.println(0);
		else {
			System.out.println(result);
		}
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(r, c, 0, 0);
		queue.add(start);
		visited[0][r][c] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int cur_r = cur.r;
			int cur_c = cur.c;
			int cur_depth = cur.depth;
			int cur_horse = cur.horse;
			visited[cur_horse][cur_r][cur_c] = true;
			if (cur_r == H - 1 && cur_c == W - 1) {
				result = cur.depth;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int dr = cur_r + dx[d];
				int dc = cur_c + dy[d];
				if (dr < 0 || dr > H - 1 || dc < 0 || dc > W - 1)
					continue;
				if (!visited[cur_horse][dr][dc] && board[dr][dc] == 0) {
					visited[cur_horse][dr][dc] = true;
					queue.add(new Node(dr, dc, cur_depth + 1, cur_horse));
				}
			}
			if (cur.horse < K) {
				for (int h = 0; h < 8; h++) {
					int hr = cur_r + hx[h];
					int hc = cur_c + hy[h];
					if (hr < 0 || hr > H - 1 || hc < 0 || hc > W - 1)
						continue;
					if (!visited[cur_horse + 1][hr][hc] && board[hr][hc] == 0) {
						visited[cur_horse + 1][hr][hc] = true;
						queue.add(new Node(hr, hc, cur_depth + 1, cur_horse + 1));
					}
				}
			}
		}

	}

	static class Node {
		int r;
		int c;
		int depth;
		int horse;

		public Node(int r, int c, int depth, int horse) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.horse = horse;
		}
	}

}