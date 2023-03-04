import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int round = Integer.parseInt(br.readLine());
		for (int i = 0; i < round; i++) {
			int A_star = 0;
			int A_circle = 0;
			int A_square = 0;
			int A_triangle = 0;
			int B_star = 0;
			int B_circle = 0;
			int B_square = 0;
			int B_triangle = 0;
			StringTokenizer A = new StringTokenizer(br.readLine());
			StringTokenizer B = new StringTokenizer(br.readLine());
			int numA = Integer.parseInt(A.nextToken());
			for (int j = 0; j < numA; j++) {
				switch (Integer.parseInt(A.nextToken())) {
				case 4:
					A_star++;
				case 3:
					A_circle++;
				case 2:
					A_square++;
				case 1:
					A_triangle++;
				}
			}
			int numB = Integer.parseInt(B.nextToken());
			for (int j = 0; j < numB; j++) {
				switch (Integer.parseInt(B.nextToken())) {
				case 4:
					B_star++;
				case 3:
					B_circle++;
				case 2:
					B_square++;
				case 1:
					B_triangle++;
				}
			}
			if (A_star > B_star)
				System.out.println('A');
			else if (A_star == B_star && A_circle > B_circle)
				System.out.println('A');
			else if (A_star == B_star && A_circle == B_circle && A_square > B_square)
				System.out.println('A');
			else if (A_star == B_star && A_circle == B_circle && A_square == B_square && A_triangle > B_triangle)
				System.out.println('A');
			else if (A_star == B_star && A_circle == B_circle && A_square == B_square && A_triangle == B_triangle)
				System.out.println('D');
			else
				System.out.println('B');
		}
	}
}