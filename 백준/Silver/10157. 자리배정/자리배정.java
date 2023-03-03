import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		if (r * c < k)
			System.out.println(0);
		else {
			int[][] arr = new int[r][c];
			int sr = r-1;
			int sc = 0;
			for (int i = 1; i <= r * c; i++) {
				arr[sr][sc] = i;
				if (i == k) {
					System.out.print((sc+1)+" "+(r - sr));
					break;
				}
				if (sr != 0 && arr[sr - 1][sc] == 0 && (sc==0||arr[sr][sc-1]!=0))
					sr--;
				else if (sc != c-1 && arr[sr][sc + 1] == 0)
					sc++;
				else if (sr != r-1 && arr[sr + 1][sc] == 0)
					sr++;
				else if (sc != 0 && arr[sr][sc - 1] == 0)
					sc--;
			}
// 출력
//			System.out.println();
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					if (arr[i][j] < 10)
//						System.out.print("000" + arr[i][j] + " ");
//					else if (arr[i][j] < 100)
//						System.out.print("00" + arr[i][j] + " ");
//					else if (arr[i][j] < 1000)
//						System.out.print("0" + arr[i][j] + " ");
//					else if (arr[i][j] == 10000)
//						System.out.print(1000 + " ");
//					else
//						System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
	}
}