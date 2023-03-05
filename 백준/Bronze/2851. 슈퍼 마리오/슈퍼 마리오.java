import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		int sum = 0;
		int res = 0;

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();

			sum += arr[i];

			if (Math.abs(100 - sum) <= Math.abs(100 - sum + arr[i])) {
				res = sum;
			}
		}

		System.out.println(res);
	}
}