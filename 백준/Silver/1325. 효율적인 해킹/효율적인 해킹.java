import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edges;
//	static Queue<Integer> queue = new LinkedList<>();
	static boolean[] visited;
	static int hacking = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			edges[B].add(A);
		}
		int maxHacking = 0;
		int[] hackingArr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			BFS(i);
			hackingArr[i] = hacking;
			if (hacking > maxHacking) {
				maxHacking = hacking;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (hackingArr[i] == maxHacking)
				sb.append(i + " ");
		}
		System.out.println(sb);
	}

	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		hacking = 0;
		queue.add(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int curCom = queue.poll();
			hacking++;
//			visited[curCom] = true;
			for (int nextCom : edges[curCom]) {
				if (!visited[nextCom]) {
					visited[nextCom] = true;
					queue.add(nextCom);
				}
			}
		}
	}
}