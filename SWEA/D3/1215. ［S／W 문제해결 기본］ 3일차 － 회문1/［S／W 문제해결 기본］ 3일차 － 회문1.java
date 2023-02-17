import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[][] matrix = new String[8][8];

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					matrix[i][j] = str.substring(j, j + 1);
				}
			}

			int cnt = 0;

			// 가로회문 검사
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - n; j++) {
					boolean flag = true; // 디폴트로 트루, 하나라도 회문 안 맞으면 폴스
					for (int k = 0; k < n / 2; k++) { // 회문 검사
						if (!matrix[i][k + j].equals(matrix[i][n - k - 1 + j])) {
							flag = false;
							break;
						}

					}

					if (flag == true) {
						cnt++;
					}

				}
			}
			

			// 세로 회문 검사
			for (int i = 0; i <= 8 - n; i++) {
				for (int j = 0; j < 8; j++) {
					boolean flag = true;
					for (int k = 0; k < n / 2; k++) {
						if (!matrix[k + i][j].equals(matrix[n - k - 1 + i][j])) {
							flag = false;
							break;
						}
					}

					if (flag == true) {
						cnt++;
					}

				}
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}