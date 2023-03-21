import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		int[] answer = new int[N + 1];
		ArrayList<Integer>[] edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>(); // 각각 크기선언 안해주면 NullPointerException 발생
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edges[u].add(v);
			edges[v].add(u); // 양방향 간선이므로
		}
		Arrays.fill(answer, -1);
		Queue<Integer> queue = new LinkedList<>();
		int depth = 0;
		visited[R] = true;
		queue.add(R);
		while (!queue.isEmpty()) {
			int Qsize = queue.size();
			// System.out.println("poll: " + cur + " qsize: " + queue.size());
			for (int i = 0; i < Qsize; i++) {
				int cur = queue.poll();
				answer[cur] = depth;
				for (int next : edges[cur]) {
					if (!visited[next]) {
						visited[next] = true;
						queue.add(next); // 현재 노드의 자식 노드들을 큐에 추가
					}
				}
			}
			depth++; // 현재 노드에서 추가한 큐 사이즈만큼 돌고나면 깊이+1
		}
		answer[R] = 0;
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append('\n');
		}
		System.out.println(sb);
		br.close();
	}
}

//하하하하하 에러나고
//알겠지 하하하하하
//그럼 이만
//
//ψ(｀∇´)ψ