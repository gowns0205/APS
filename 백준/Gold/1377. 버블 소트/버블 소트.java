import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] A = new Node[N];
		for (int i = 0; i < N; i++) {
			A[i] = new Node(i + 1, Integer.parseInt(br.readLine()));
		}
		Arrays.sort(A);
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = A[i].index - i - 1;
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			if (result[i] > max) {
				max = result[i];
			}
		}
		System.out.println(max + 1);
	}

	static class Node implements Comparable<Node> {
		int index;
		int value;

		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

	}
}