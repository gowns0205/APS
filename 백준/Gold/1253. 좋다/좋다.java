import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(num);
		int GOOD = 0;
		for (int i = 0; i < N; i++) {
			int start_idx = 0;
			if (i == 0)
				start_idx = 1;
			int end_idx = N - 1;
			if (i == N - 1)
				end_idx = N - 2;
			long target = num[i];
			while (start_idx < end_idx) {
				long cur = num[start_idx] + num[end_idx];
				if (cur < target)
					start_idx++;
				else if (cur > target)
					end_idx--;
				else {
					GOOD++;
					break;
				}
				if (start_idx == i)
					start_idx++;
				if (end_idx == i)
					end_idx--;
			}
		}
		System.out.println(GOOD);
	}
}