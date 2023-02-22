import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int idx = 1;
		System.out.print("<");
		while (true) {
			if (idx == K && queue.size() > 1) {
				System.out.print(queue.poll() + ", ");
				idx = 1;
			} else if (queue.size() == 1) {
				System.out.print(queue.poll());
			} else {
				queue.add(queue.poll());
				idx++;
			}
			if (queue.isEmpty())
				break;
		}
		System.out.print(">");
	}
}
