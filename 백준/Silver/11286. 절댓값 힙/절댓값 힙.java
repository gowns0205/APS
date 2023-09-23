import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> myPQ = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int cur = Integer.parseInt(br.readLine());
			if (cur != 0) {
				myPQ.add(new Node(Math.abs(cur), cur));
			}
			if (cur == 0) {
				if (myPQ.isEmpty()) {
					sb.append(0 + "\n");
					continue;
				}
				sb.append(myPQ.poll().real + "\n");
			}
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int abs;
		int real;

		Node(int abs, int real) {
			this.abs = abs;
			this.real = real;
		}
		@Override
		public int compareTo(Node o) {
			if (this.abs == o.abs) {
				return this.real - o.real;
			}
			return this.abs - o.abs;
		}
	}
}