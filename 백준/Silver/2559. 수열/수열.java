import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int tmpSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(st2.nextToken());
			tmpSum += tmp;
			queue.add(tmp);
			if (i >= K) {
				if (tmpSum > maxSum)
					maxSum = tmpSum;
				tmpSum -= queue.poll();
			}
		}
		System.out.println(maxSum);
	}
}