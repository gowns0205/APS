import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이 문제는 음수도 있기 때문에 정렬 뒤에 포인터를 이동한다고 해서 항상 절댓값이 줄어드는 것은 아니다. 

public class Main {
	static int N;
	static int left;
	static int right;
	static int result_L;
	static int result_R;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		twoPointers(arr);
		System.out.println(result_L + " " + result_R);
	}

	private static void twoPointers(int[] arr) {
		left = 0;
		right = N - 1;
		int curSum = 0;
		int minSum = 2000000001;
		while (left < right) {
			curSum = arr[left] + arr[right];
			if (Math.abs(curSum) < minSum) {
				result_L = arr[left];
				result_R = arr[right];
				minSum = Math.abs(curSum);
			}
			//System.out.println("left: " + arr[left] + " right: " + arr[right] + " curSum: " + curSum + " minSum: "+minSum);
			if (curSum == 0) {
				return;
			} else if (curSum > 0) {
				right--;
			} else {
				left++;
			}
		}
	}
}