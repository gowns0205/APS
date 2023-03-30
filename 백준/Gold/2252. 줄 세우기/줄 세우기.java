import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			inDegree[B]++;
		}
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			for (int next : graph[cur]) {
				inDegree[next]--;
				if (inDegree[next] == 0)
					queue.add(next);
			}
		}
	}
}