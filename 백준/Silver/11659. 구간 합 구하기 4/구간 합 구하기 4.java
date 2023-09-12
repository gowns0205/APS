import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] num = new int[N + 1];
		long[] prefixSum = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum += num[i];
			prefixSum[i] = sum;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long result = prefixSum[end] - prefixSum[start-1];
			System.out.println(result);
		}
	}
}