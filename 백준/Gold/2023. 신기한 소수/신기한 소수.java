import java.util.*;

public class Main {
	static int[] nextDigit = { 1, 3, 7, 9 };
	static int N;
	static ArrayList<Integer> amazingPrimeNumberList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		amazingPrimeNumberList = new ArrayList<>();
		int[] start = { 2, 3, 5, 7 };
		for (int i = 0; i < 4; i++) {
			DFS(start[i], 1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i:amazingPrimeNumberList)
			sb.append(i+"\n");
		System.out.println(sb);
	}

	static void DFS(int num, int depth) {
		if (depth == N) {
			amazingPrimeNumberList.add(num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nextNum = num * 10 + nextDigit[i];
			if (isPrime(nextNum))
				DFS(nextNum, depth + 1);
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0 && num > 2) {
				return false;
			}
		}
		return true;
	}
}