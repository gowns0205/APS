import java.util.*;
import java.io.*;

public class Main {
	static int B;
	static int min;

	static void BFS(long start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 1));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.num > B)
				continue;
			if (cur.num == B) {
				min = cur.depth;
				break;
			}
			queue.add(new Node(cur.num * 2, cur.depth + 1));
			queue.add(new Node(cur.num * 10 + 1, cur.depth + 1));
		}
	}

	static class Node {
		long num;
		int depth;

		Node(long num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		B = sc.nextInt();
		min = 100;
		BFS(A);
		if (min == 100)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}