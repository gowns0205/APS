import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList();
		int N = sc.nextInt();
		list.add(0);
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			list.add(i-num,i);
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}