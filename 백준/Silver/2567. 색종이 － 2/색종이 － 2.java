import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] matrix = new int[101][101];

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
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];

						if (nr >= 0 && nr <= 100 && nc >= 0 && nc <= 100) {
							if (matrix[nr][nc] == 0) {
								cnt++;
							}
						}
					}
				}

			}
		}
		System.out.println(cnt);

	}
}