import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 접근 방식
// 1. 어떤 숫자에서 뒤에 붙는 0의 개수는 10의 계수와 같다. 
// 2. 10은 2와 5의 곱이다. 
// 3. 연속된 수를 계속 곱하면 소인수분해 했을때 5보다는 2 개수가 많게 된다.  
// 4. 그러므로 [뒤에 붙는 0의 개수 = 소인수 5의 개수] 이다.

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N >= 5) {
			cnt += N / 5;
			N /= 5;
		}
		System.out.println(cnt);
	}
}
