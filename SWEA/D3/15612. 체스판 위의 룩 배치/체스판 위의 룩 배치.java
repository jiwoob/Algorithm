import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String[][] matrix = new String[8][8];

			for (int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					matrix[i][j] = str.substring(j, j + 1);
				}
			}

			// 디폴트를 트루로 놓고,
			boolean flag = true;

			// 가로에 O 하나인지 검사. 한줄이라도 조건 만족 못하면 false, break!
			for (int i = 0; i < 8; i++) {
				int cnt = 0;
				for (int j = 0; j < 8; j++) {
					if (matrix[i][j].equals("O"))
						cnt++;
				}
				if (cnt != 1) {
					flag = false;
					break;
				}
			}

			// 세로에 O 하나인지 검사.
			for (int i = 0; i < 8; i++) {
				int cnt = 0;
				for (int j = 0; j < 8; j++) {
					if (matrix[j][i].equals("O"))
						cnt++;
				}
				if (cnt != 1) {
					flag = false;
					break;
				}
			}

			String res = "";
			if (flag == false) {
				res = "no";
			} else {
				res = "yes";
			}

			System.out.println("#" + tc + " " + res);

		}

	}
}