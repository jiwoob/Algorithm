
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();

		int[][] matrix = new int[R][C];

		// 입력할 숫자
		int cnt = 1;

		// 처음 시작하는 행, 열 인덱스
		int a = R - 1;
		int b = 0;

		// 방향을 나타내는 값 (처음 - 위로 가는 방향)
		int dir = 1;

		while (cnt <= C * R) {

			if (dir == 1) { // 위로 갈 때.

				// 경계조건
				if (a >= 0 && matrix[a][b] == 0) {
					matrix[a][b] = cnt;
					cnt++;
					a--;
				} else {
					dir = 2; // 오른쪽 방향으로 틀어주기
					a++;
					b++;
				}
			}

			if (dir == 2) { // 오른쪽으로 갈 때.

				if (b <= C - 1 && matrix[a][b] == 0) {
					matrix[a][b] = cnt;
					cnt++;
					b++;
				} else {
					dir = 3; // 아래 방향으로 틀어주기
					b--;
					a++;
				}
			}

			if (dir == 3) { // 아래로 갈 때.

				if (a <= R - 1 && matrix[a][b] == 0) {
					matrix[a][b] = cnt;
					cnt++;
					a++;
				} else {
					dir = 4; // 왼쪽 방향으로 틀어주기.
					a--;
					b--;
				}

			}

			if (dir == 4) {

				if (b >= 0 && matrix[a][b] == 0) {
					matrix[a][b] = cnt;
					cnt++;
					b--;
				} else {
					dir = 1;
					b++;
					a--;
				}
			}

		}

		if (K > R * C) {
			System.out.println(0);
		}

		// 주어진 숫자에 따른 좌표 찾기
		for (int i = R; i >= 1; i--) {
			for (int j = 1; j <= C; j++) {
				if (matrix[i - 1][j - 1] == K) {
					System.out.println(j + " " + (R - i + 1));
				}
			}
		}

	}
}
