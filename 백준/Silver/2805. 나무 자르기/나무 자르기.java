import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		int maxTree = pq.peek();
		int maxHeight = 0;
		int trees = 0;
		int lastIdx = 0;
		int sum = 0;
		for (int i = maxTree; i > 0; i--) {
			int cnt = 0;
			if (!pq.isEmpty()) {
				while (i == pq.peek()) {
					pq.poll();
					trees++;
					cnt++;
					lastIdx = i;
					if (pq.isEmpty())
						break;
				}
			}
			if (i == lastIdx) {
				sum += trees - cnt;
			} else {
				sum += trees;
			}
			// System.out.printf("trees:%d, Height:%d, sum:%d\n", trees, i, sum);
			if (sum >= M) {
				maxHeight = i;
				break;
			}
		}
		System.out.println(maxHeight);
	}
}