import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		String str = br.readLine();
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] cnt = new int[4];
		int result = 0;
		for (int i = 0; i <= s - p; i++) {
			int head = i;
			int tail = i + p - 1;
			if (i == 0) {
				for (int j = 0; j < p; j++) {
					char ch = str.charAt(j);
					if (ch == 'A')
						cnt[0]++;
					else if (ch == 'C')
						cnt[1]++;
					else if (ch == 'G')
						cnt[2]++;
					else if (ch == 'T')
						cnt[3]++;
				}
			} else {
				char in = str.charAt(tail);
				char out = str.charAt(head - 1);

				if (in == 'A')
					cnt[0]++;
				else if (in == 'C')
					cnt[1]++;
				else if (in == 'G')
					cnt[2]++;
				else if (in == 'T')
					cnt[3]++;
				if (out == 'A')
					cnt[0]--;
				else if (out == 'C')
					cnt[1]--;
				else if (out == 'G')
					cnt[2]--;
				else if (out == 'T')
					cnt[3]--;
			}
			if (cnt[0] >= A && cnt[1] >= C && cnt[2] >= G && cnt[3] >= T)
				result++;
		}
		System.out.println(result);
		br.close();
	}
}