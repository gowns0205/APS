import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int count = 0;
		// 합친 카드 뭉치가 다음 카드 뭉치보다 커질 수 있으므로 우선순위 큐 사용
		while (pq.size() > 1) {
			int A = pq.poll();
			int B = pq.poll();
			count += A + B;
			pq.add(A + B);
		}
		System.out.println(count);
	}
}