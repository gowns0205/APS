import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static boolean[][] visited;
	static Queue<Node> queue;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Integer> list;
	static int idx = 0;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					list.add(0);
					BFS(r, c);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size() + "\n");
		for (int i : list) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}

	static void BFS(int r, int c) {
		int num = 1;
		queue.add(new Node(r, c));
		list.set(idx, num);
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dr = curNode.r + dy[i];
				int dc = curNode.c + dx[i];
				if (dr < 0 || dr > N - 1 || dc < 0 || dc > N - 1)
					continue;
				if (!visited[dr][dc] && map[dr][dc] == 1) {
					visited[dr][dc] = true;
					queue.add(new Node(dr, dc));
					num++;
					list.set(idx, num);
				}
			}
		}
		idx++;
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