import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int idx = 0;
	static ArrayList<Integer>[] edge;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new int[N + 1]; // 플래그 배열
		Arrays.fill(visited, -1); // boolean 배열의 기본값은 null
		edge = new ArrayList[N + 1];
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
			Collections.sort(edge[i]); // 인접 정점은 오름차순으로 방문
		visited[R] = 0;
		dfs(R, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}

	public static void dfs(int cur, int depth) {
		visited[cur] = depth;
		for (int next : edge[cur]) {
			if (visited[next] != -1)
				continue;
			dfs(next, depth + 1);
		}
	}
}