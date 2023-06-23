import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이분탐색 문제. 그냥 for문으로 풀면 시간초과
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		long min = 0;
		long max = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max)
				max = arr[i];
		}
		max++;
		long mid = 0;
		while (min < max) {
			mid = (min + max) / 2;
			long cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}
			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min -1);
	}
}