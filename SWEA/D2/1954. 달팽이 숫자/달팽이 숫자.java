import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2001
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		// System.out.println(t);

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][n];

			int a = 0; // 행
			int b = 0; // 열

			int value = 1; // 1부터 찍을 값.

			int dr = 1;

			while (value <= n * n) {
				// right
				if (dr == 1) {
					if (b <= n - 1 && arr[a][b] == 0) {
						arr[a][b] = value;
						value++;
						b++;
					} else {
						b--;
						a++;
						dr = 2;
					}

				}

				// down
				if (dr == 2) {
					if (a <= n - 1 && arr[a][b] == 0) {
						arr[a][b] = value;
						value++;
						a++;
					} else {
						a--;
						b--;
						dr = 3;
					}
				}

				// left
				if (dr == 3) {
					if (b >= 0 && arr[a][b] == 0) {
						arr[a][b] = value;
						value++;
						b--;
					} else {
						b++;
						a--;
						dr = 4;
					}
				}

				// up
				if (dr == 4) {
					if (a >= 0 && arr[a][b] == 0) {
						arr[a][b] = value;
						value++;
						a--;
					} else {
						a++;
						b++;
						dr = 1;
					}

				}

			}

			// 출력
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		} // tc

	}
}