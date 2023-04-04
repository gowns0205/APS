import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] room;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken()); // 시작 좌표, 방향
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int R = sr; // 현재 좌표, 방향
		int C = sc;
		int D = sd;
		int cnt = 0; // 지금까지 청소한 영역
		int idx = 0;
		while (true) {
			if (room[R][C] == 0) {
				room[R][C] = 2;
				cnt++;
			}
			boolean turn = false;
			for (int d = 0; d < 4; d++) {
				int dr = R + dx[d];
				int dc = C + dy[d];
				if (dr < 1 || dr > N - 2 || dc < 1 || dc > M - 2)
					continue;
				if (room[dr][dc] == 0) {
					turn = true;
					break;
				}
			}

			if (turn) {
				for (int d = 0; d < 3; d++) {
					if (D == 0)
						D = 3;
					else
						D--;
					// System.out.println(d);
					// System.out.println("d: " + d + "D: " + D);
					if (D == 0) {
						if (R - 1 < 1 || room[R - 1][C] != 0)
							continue;
						else {
							R--;
							break;
						}
					} else if (D == 1) {
						if (C + 1 > M - 2 || room[R][C + 1] != 0)
							continue;
						else {
							C++;
							break;
						}
					} else if (D == 2) {
						if (R + 1 > N - 2 || room[R + 1][C] != 0)
							continue;
						else {
							R++;
							break;
						}
					} else if (D == 3) {
						if (C - 1 < 1 || room[R][C - 1] != 0)
							continue;
						else {
							C--;
							break;
						}
					}
				}

			} else {
				if (D == 0) {
					if (R + 1 < N - 1 && room[R + 1][C] != 1)
						R++;
					else
						break;
				} else if (D == 1) {
					if (C - 1 > 0 && room[R][C - 1] != 1)
						C--;
					else
						break;
				} else if (D == 2) {
					if (R - 1 > 0 && room[R - 1][C] != 1)
						R--;
					else
						break;
				} else if (D == 3) {
					if (C + 1 < M - 1 && room[R][C + 1] != 1)
						C++;
					else
						break;
				}
			}

		}
		System.out.println(cnt);
	}
}