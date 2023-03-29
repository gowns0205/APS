import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] box;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == 1) {
					queue.add(new Node(r, c));
					visited[r][c] = true;
				}
			}
		}
		int day = 0;
		while (true) {
			if (queue.isEmpty())
				break;
			int size = queue.size();
			while (size-- > 0) {
				Node curNode = queue.poll();
				int r = curNode.r;
				int c = curNode.c;
				box[r][c] = 1;
				for (int i = 0; i < 4; i++) {
					int dr = r + dy[i];
					int dc = c + dx[i];
					if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1)
						continue;
					if (!visited[dr][dc] && box[dr][dc] == 0) {
						queue.add(new Node(dr, dc));
						visited[dr][dc] = true;
					}
				}
			}
			day++;
		}
		boolean result = true;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					result = false;
					break;
				}
			}
		}
		if (!result)
			System.out.println(-1);
		else if (day == 0)
			System.out.println(0);
		else
			System.out.println(day - 1);
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