import java.util.*;
import java.io.*;

public class Main {
	static int B;
	static int min;

	static void DFS(long cur, int depth) {
		if (cur == B) {
			if (depth < min)
				min = depth;
			return;
		}
		if (cur > B)
			return;
		DFS(cur * 2, depth+1);
		DFS(cur * 10 + 1, depth+1);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		B = sc.nextInt();
		min = 100;
		DFS(A, 1);
		if (min == 100)
			System.out.println(-1);
		else
			System.out.println(min);
	}

}