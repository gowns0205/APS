import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<int[]> combList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][2];
			int[] nums = new int[N];
			boolean[] visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				nums[i] = i;
			}
			int maxScore = 0;
			for (int r = 1; r <= N; r++) {
				combList = new ArrayList<>();
				combination(nums, visited, 0, 0, r);
				for (int i = 0; i < combList.size(); i++) {
					int calSum = 0;
					int scoreSum = 0;
					for (int j = 0; j < r; j++) {
						scoreSum += arr[combList.get(i)[j]][0];
						calSum += arr[combList.get(i)[j]][1];
					}
					if (calSum <= L && scoreSum > maxScore)
						maxScore = scoreSum;
				}
			}
			System.out.printf("#%d %d\n", tc, maxScore);
		}
	}

	private static void combination(int[] nums, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			int[] result = new int[r];
			int idx = 0;
			for (int i = 0; i < nums.length; i++) {
				if (visited[i]) {
					result[idx] = i;
					idx++;
				}
			}
			combList.add(result);
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combination(nums, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}

	}
}