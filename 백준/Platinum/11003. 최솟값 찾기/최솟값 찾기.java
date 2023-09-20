import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			Node cur = new Node(i, Integer.parseInt(st.nextToken()));
			while (true) {
				// 첫 번째 노드인 경우 or 현재 노드의 값이 덱에서 최솟값인 경우
				if (deque.isEmpty()) {
					deque.add(cur);
					break;
				}
				Node last = deque.peekLast();
				// 현재 노드의 값이 덱의 마지막 노드 값보다 클때까지 반복
				if (last.value > cur.value) {
					deque.removeLast();
					continue;
				}
				Node first = deque.peekFirst();
				// 덱의 맨 앞 노드 인덱스가 슬라이딩 윈도우 크기를 벗어나면 제거
				if (cur.index - first.index >= L) {
					deque.removeFirst();
				}
				deque.add(cur);
				break;
			}
			sb.append(deque.peekFirst().value + " ");
		}
		System.out.println(sb);
	}

	static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}