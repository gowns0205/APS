import java.util.*;
import java.io.*;

public class Main {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		combination(visited, M, 0, 0);
		br.close();
	}

	static void combination(boolean[] visited, int r, int depth, int start) {
		if (depth == r) {
			ArrayList<Integer> result = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if(visited[i])
					result.add(i);
			}
			if(result.size()==r) {
				for(int i=0; i<result.size(); i++)
					System.out.print(result.get(i)+" ");
				System.out.println();
			}
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(visited, r, depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}