import java.util.*;
import java.io.*;

// 중복조합 문제
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
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] out = new int[M];
		Arrays.sort(num);
		permutation(num, M, out, 0,1);
		// 이런 문법도 있다.
		// answer.forEach(System.out::println);
		Iterator<String> iter = answer.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		br.close();
	}

	static void permutation(int[] num, int r, int[] out, int depth, int start) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < r; i++)
				sb.append(out[i] + " ");
			answer.add(sb.toString());
			return;
		}
		for (int i = start; i <= N; i++) {
			out[depth] = num[i];
			permutation(num, r, out, depth + 1, i);
		}
	}
}