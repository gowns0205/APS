import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] armor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			armor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(armor);
		int start_idx = 0;
		int end_idx = N - 1;
		int count = 0; // 갑옷 만들 수 있는 경우의 수
		while (start_idx < end_idx) {
			int sum = armor[start_idx] + armor[end_idx];
			if (sum < M) {
				start_idx++;
			} else if (sum > M) {
				end_idx--;
			} else {
				count++;
				start_idx++;
			}
		}
		System.out.println(count);
	}
}