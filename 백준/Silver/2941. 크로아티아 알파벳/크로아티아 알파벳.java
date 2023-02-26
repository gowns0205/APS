import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] arr = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != 0) {
				if (arr[i - 1] == 'c' && arr[i] == '=')
					cnt++;
				else if (arr[i - 1] == 'c' && arr[i] == '-')
					cnt++;
				else if (arr[i - 1] == 'd' && arr[i] == '-')
					cnt++;
				else if (arr[i - 1] == 'l' && arr[i] == 'j')
					cnt++;
				else if (arr[i - 1] == 'n' && arr[i] == 'j')
					cnt++;
				else if (arr[i - 1] == 's' && arr[i] == '=')
					cnt++;
				else if (i > 1 && arr[i - 2] == 'd' && arr[i - 1] == 'z' && arr[i] == '=')
					cnt += 2;
				else if (arr[i - 1] == 'z' && arr[i] == '=')
					cnt++;
			}
		}
		System.out.println(s.length() - cnt);
	}
}