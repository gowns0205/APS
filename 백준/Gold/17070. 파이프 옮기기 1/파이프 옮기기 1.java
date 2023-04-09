import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][][] visited;
	static int N;
	static int route = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N][3];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0][1][0] = true;
		DFS(0, 1, 0);
		System.out.println(route);
	}

	private static void DFS(int r, int c, int position) {
		if (r == N - 1 && c == N - 1)
			route++;
		// 가로
		if (position == 0) {
			if (c + 1 < N && !visited[r][c + 1][0] && map[r][c + 1] != 1) {
				visited[r][c + 1][0] = true;
				DFS(r, c + 1, 0);
				visited[r][c + 1][0] = false;
			}
			if (r + 1 < N && c + 1 < N && !visited[r + 1][c + 1][2] && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1
					&& map[r + 1][c] != 1) {
				visited[r + 1][c + 1][2] = true;
				DFS(r + 1, c + 1, 2);
				visited[r + 1][c + 1][2] = false;
			}
		}
		// 세로
		else if (position == 1) {
			if (r + 1 < N && !visited[r + 1][c][1] && map[r + 1][c] != 1) {
				visited[r + 1][c][1] = true;
				DFS(r + 1, c, 1);
				visited[r + 1][c][1] = false;
			}
			if (r + 1 < N && c + 1 < N && !visited[r + 1][c + 1][2] && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1
					&& map[r + 1][c] != 1) {
				visited[r + 1][c + 1][2] = true;
				DFS(r + 1, c + 1, 2);
				visited[r + 1][c + 1][2] = false;
			}

		}
		// 대각선
		else {
			if (c + 1 < N && !visited[r][c + 1][0] && map[r][c + 1] != 1) {
				visited[r][c + 1][0] = true;
				DFS(r, c + 1, 0);
				visited[r][c + 1][0] = false;
			}
			if (r + 1 < N && !visited[r + 1][c][1] && map[r + 1][c] != 1) {
				visited[r + 1][c][1] = true;
				DFS(r + 1, c, 1);
				visited[r + 1][c][1] = false;
			}
			if (r + 1 < N && c + 1 < N && !visited[r + 1][c + 1][2] && map[r + 1][c + 1] != 1 && map[r][c + 1] != 1
					&& map[r + 1][c] != 1) {
				visited[r + 1][c + 1][2] = true;
				DFS(r + 1, c + 1, 2);
				visited[r + 1][c + 1][2] = false;
			}
		}
	}
}