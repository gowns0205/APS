import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = N;
		String s = sc.next();
		char[] seats = new char[N];
		for (int i = 0; i < N; i++) {
			seats[i] = s.charAt(i);
		}
		int idx = -1;
		boolean allS = true;
		for (int i = 0; i < N; i++) {
			if (i != 0 && i > idx && seats[i - 1] == 'L' && seats[i] == 'L') {
				max--;
				//System.out.println("i= " + i);
				allS = false;
				idx = i + 1;
			}
		}
		if (!allS)
			max++;
		System.out.println(max);
	}
}