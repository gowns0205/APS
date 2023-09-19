import java.util.*;
import java.io.*;

// 조합 문제
// LinkedHashSet을 이용해 순서 유지, 중복 방지
public class Main {

	static int N;
	static StringBuilder sb;
	static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		answer = new LinkedHashSet<>();
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		permutation(num, visited, M, 0, 1);
		// 이런 문법도 있다.
		// answer.forEach(System.out::println); 
		Iterator<String> iter = answer.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		br.close();
	}

	static void permutation(int[] num, boolean[] visited, int r, int depth, int start) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<=N; i++)
				if(visited[i])
					sb.append(num[i]+" ");
			answer.add(sb.toString());
			return;
		}
		for (int i = start; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(num, visited, r, depth + 1, i+1);
				visited[i] = false;
			}
		}
	}
}