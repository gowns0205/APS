import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] answer;
	static int idx = 0;
	static ArrayList<Integer>[] edge;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		edge = new ArrayList[N + 1];
		answer = new int[N + 1];
		Arrays.fill(answer, -1);
		visited = new boolean[N + 1]; // 플래그 배열
		Arrays.fill(visited, false); // boolean 배열의 기본값은 null
		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<Integer>(); // 위에서 크기 선언 안해주면 여기서 NullPointerException 발생
		}
		for (int i = 1; i <= M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			edge[u].add(v); // 양방향 간선
			edge[v].add(u);
		}
		for (int i = 1; i <= N; i++)
			Collections.sort(edge[i], Collections.reverseOrder()); // 인접 정점은 내림차순 방문!
		visited[R] = true;
		answer[R] = 0;
		dfs(R, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int cur, int depth) {
		answer[cur] = depth;
		depth++;
		for (int next : edge[cur]) {
			if (visited[next])
				continue;
			visited[next] = true;
			dfs(next, depth);
		}
	}
}