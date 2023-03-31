import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N + 1];
		int[] result = new int[N + 1];
		int[] inDegree = new int[N + 1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1)
					break;
				graph[num].add(i);
				inDegree[i]++;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				result[i] = time[i];
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : graph[cur]) {
				result[next] = Math.max(result[next], result[cur] + time[next]);
				inDegree[next]--;
				if (inDegree[next] == 0)
					queue.add(next);
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
	}

}