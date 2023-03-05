import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int n = str.length();

		int R = 0, C = 0;
		// R,C
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				R = i;
				C = n / i;
			}
		}

		char[][] arr = new char[R][C];

		int cnt = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = str.charAt(cnt);
				cnt++;
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}
}