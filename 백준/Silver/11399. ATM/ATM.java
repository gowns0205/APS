import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		PriorityQueue<Integer> atmQueue = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for (int i = 0; i < N; i++) {
			atmQueue.add(Integer.parseInt(st.nextToken()));
		}
		int sum = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = atmQueue.poll();
			for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
		}
		System.out.println(sum);
		br.close();
	}
}