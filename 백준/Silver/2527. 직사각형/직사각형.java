import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 4; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			if ((x1 == p2 && y1 == q2) || (x1 == p2 && y2 == q1) || (x2 == p1 && y2 == q1) || (x2 == p1 && y1 == q2))
				System.out.println('c');
			else if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1)
				System.out.println('d');
			else if (q1 == y2 || q2 == y1 || p1 == x2 || p2 == x1)
				System.out.println('b');
			else
				System.out.println('a');
		}
	}
}