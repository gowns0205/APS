import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] queue = new int[2000000];
	public static int front = -1;
	public static int rear = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int last = 0;
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String command = st.nextToken();
			if (command.equals("push")) {
				String num = st.nextToken();
				int n = Integer.parseInt(num);
				enQueue(n);
				last = n;
			} else if (command.equals("pop")) {
				if (isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(deQueue()).append('\n');
				}
			} else if (command.equals("size")) {
				sb.append(size()).append('\n');
			} else if (command.equals("empty")) {
				sb.append((isEmpty()) ? 1 : 0).append('\n');
			} else if (command.equals("front")) {
				if (isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(peek()).append('\n');
			} else if (command.equals("back")) {
				if (isEmpty())
					sb.append(-1).append('\n');
				else {
					sb.append(last).append('\n');
				}
			}
		}
		System.out.print(sb);
	}

	public static void enQueue(int item) {
		queue[++rear] = item;
	}

	public static int deQueue() {
		if (isEmpty())
			return -1;
		else {
			return queue[++front];
		}
	}

	public static int size() {
		if (isEmpty())
			return 0;
		else
			return rear - front;
	}

	public static int peek() {
		if (isEmpty())
			return -1;
		else {
			return queue[front + 1];
		}
	}

	public static boolean isEmpty() {
		return front == rear;
	}
}