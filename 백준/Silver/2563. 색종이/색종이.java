import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] matrix = new int[100][100];

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = b; j < b + 10; j++) {
				for (int k = a; k < a + 10; k++) {
					matrix[j][k] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (matrix[i][j] == 1) {
					cnt++;
				}
			}
		}

		System.out.println(cnt);

	}
}