import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N + 1];
		int count = 1; // 가지수
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		while (end_idx < N) {
			if (sum < N) {
				end_idx++;
				sum += end_idx;
			} else if (sum > N) {
				sum -= start_idx;
				start_idx++;
			} else {
				end_idx++;
				sum += end_idx;
				count++;
			}
		}
		System.out.println(count);
	}
}