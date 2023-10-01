import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lectures = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxLen = 0;
		long start = 0;
		long end = 0;
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			end += lectures[i];
			if (lectures[i] > maxLen) {
				maxLen = lectures[i];
				start = maxLen;
			}
		}
		long mid = 0;
		long minSize = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			int bluelay = 1;
			long storage = 0;
			for (int i = 0; i < N; i++) {
				if (storage + lectures[i] <= mid) {
					storage += lectures[i];
				} else {
					bluelay++;
					storage = 0;
					storage += lectures[i];
				}
			}
			if (bluelay <= M) {
				end = mid - 1;
				minSize = mid;
			}
			if (bluelay > M) {
				start = mid + 1;
			}
		}
		System.out.println(minSize);
	}
}