import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		long maxSum = 0;
		long tmpSum = 0;
		for (int i = 0; i < K; i++) {
			tmpSum += arr[i];
		}
		maxSum = tmpSum;
		int idx = 0;
		while (true) {
			if (idx + K > N - 1)
				break;
			tmpSum -= arr[idx];
			tmpSum += arr[idx + K];
			if (tmpSum > maxSum)
				maxSum = tmpSum;
			idx++;
		}
		System.out.println(maxSum);
	}
}