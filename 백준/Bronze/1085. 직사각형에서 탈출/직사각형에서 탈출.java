import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int minX = 0;
		int minY = 0;
		int result = 0;
		minX = Math.min(w - x, x);
		minY = Math.min(h - y, y);
		result = Math.min(minX, minY);
		System.out.println(result);
	}
}