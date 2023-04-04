import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] tmpMap;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] result;
	static boolean[][] visited_map;
	static int[] nums;
	static int N;
	static int W;
	static int H;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 공을 쏠 수 있는 횟수 = r
			W = Integer.parseInt(st.nextToken()); // 공을 쏠 수있는 위치의 개수 = n
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			nums = new int[W];
			result = new int[N];
			list = new ArrayList<>();
			for (int i = 0; i < W; i++) {
				nums[i] = i;
			}
			permutation(0);
			int minCnt = 200;
			for (int i = 0; i < list.size(); i++) { // 리스트의 크기 = 경우의 수
			tmpMap = new int[H][W];
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					tmpMap[r][c] = map[r][c];
				}
			}
			for (int j = 0; j < N; j++) {
				int c = list.get(i)[j]; // 현재 열 위치
				a: for (int r = 0; r < H; r++) {
					if (tmpMap[r][c] != 0) {
						BFS(r, c, tmpMap[r][c]);
						// 남은 블럭 아래로 정리
						int[][] move = new int[H][W];
						for (int cc = 0; cc < W; cc++) {
							int idx = H - 1;
							for (int rr = H - 1; rr >= 0; rr--) {
								if (tmpMap[rr][cc] != 0) {
									move[idx][cc] = tmpMap[rr][cc];
									idx--;
								}
							}
						}
						for (int rr = 0; rr < H; rr++) {
							for (int cc = 0; cc < W; cc++) {
								tmpMap[rr][cc] = move[rr][cc];
							}
						}
						break a;
					}
				}
			}
			// 남은 블럭 수 세기
			int cnt = 0;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (tmpMap[r][c] != 0)
						cnt++;
				}
			}
			if (cnt < minCnt)
				minCnt = cnt;
			}
			sb.append("#"+tc+" "+minCnt+"\n");
		}
		System.out.println(sb);
	}

	private static void BFS(int r, int c, int power) {
		visited_map = new boolean[H][W];
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(r, c, power);
		queue.add(start);
		visited_map[r][c] = true;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int tr = cur.r;
			int tc = cur.c;
			int tp = cur.power;
			tmpMap[tr][tc] = 0;
			for (int p = 0; p < tp; p++) {
				for (int d = 0; d < 4; d++) {
					int dr = tr + dx[d] * p;
					int dc = tc + dy[d] * p;
					if (dr < 0 || dr > H - 1 || dc < 0 || dc > W - 1)
						continue;
					if (!visited_map[dr][dc] && tmpMap[dr][dc] != 0) {
						visited_map[dr][dc] = true;
						queue.add(new Node(dr, dc, tmpMap[dr][dc]));
					}
				}
			}

		}
	}

	static void permutation(int idx) {
		// N==r
		if (idx == N) {
			int[] tmp = new int[N];
			tmp = Arrays.copyOfRange(result, 0, N);
			list.add(tmp);
			return;
		}
		for (int i = 0; i < W; i++) {
			result[idx] = nums[i];
			permutation(idx + 1);
		}
	}

	static class Node {
		int r;
		int c;
		int power;

		public Node(int r, int c, int power) {
			super();
			this.r = r;
			this.c = c;
			this.power = power;
		}
	}
}