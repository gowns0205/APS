import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] box;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		Queue<Tomato> queue = new LinkedList<>();
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					box[h][r][c] = Integer.parseInt(st.nextToken());
					if (box[h][r][c] == 1) {
						queue.add(new Tomato(h, r, c));
						visited[h][r][c] = true;
					}
				}
			}
		}
		int day = 0;
		while (true) {
			if (queue.isEmpty())
				break;
			int size = queue.size();
			while (size-- > 0) {
				Tomato curTomato = queue.poll();
				int r = curTomato.r;
				int c = curTomato.c;
				int h = curTomato.h;
				box[h][r][c] = 1;
				for (int i = 0; i < 6; i++) {
					int dr = r + dy[i];
					int dc = c + dx[i];
					int dh = h + dz[i];

					if (dr < 0 || dr > N - 1 || dc < 0 || dc > M - 1 || dh < 0 || dh > H - 1)
						continue;
					if (!visited[dh][dr][dc] && box[dh][dr][dc] == 0) {
						queue.add(new Tomato(dh, dr, dc));
						visited[dh][dr][dc] = true;
					}
				}
			}
			day++;
		}
		boolean result = true;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (box[h][r][c] == 0) {
						result = false;
						break;
					}
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

	static class Tomato {
		int h;
		int r;
		int c;

		public Tomato(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

}