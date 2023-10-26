import java.util.*;
import java.io.*;

public class Main {
	static char[] A;
	static int k;
	static int[] num;
	static ArrayList<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		A = new char[k];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			A[i] = st.nextToken().charAt(0);
		}
		num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i] = i;
		}
		boolean[] visited = new boolean[10];
		DFS(0, "", 0, visited);
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	static void DFS(int depth, String result, int pre, boolean[] visited) {
		if (depth == k + 1) {
			list.add(result);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				visited[i] = true;
				String cur = "";
				cur += result;
				if (depth == 0) {
					cur += Integer.toString(i);
					DFS(depth + 1, cur, i, visited);
				}
				if (depth > 0) {
					char sign = A[depth - 1];
					if (sign == '>' && pre > i) {
						cur += Integer.toString(i);
						DFS(depth + 1, cur, i, visited);
					}
					if (sign == '<' && pre < i) {
						cur += Integer.toString(i);
						DFS(depth + 1, cur, i, visited);
					}
				}
				visited[i] = false;
			}
		}
	}
}