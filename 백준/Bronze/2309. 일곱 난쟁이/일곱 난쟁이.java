import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
			a : for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (i != j) {
						int tmp = sum - arr[i] - arr[j];
						if (tmp == 100) {
							arr[i] = arr[j] = -1;
							for (int k : arr) {
								if (k != -1)
									System.out.println(k);
							}
							break a ;
						}
						
					}
					
					}
				}
			}
		}