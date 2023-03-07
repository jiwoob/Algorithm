import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*색종이 번호에 맞게 1,2,3 ...n으로 채운다.
 * 1의 개수, 2의 개수 ...가 결국 보이는 면적이 된다.
 * */

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] matrix = new int[1001][1001];

		int N = Integer.parseInt(br.readLine());

		int cnt = 1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

			for (int j = x; j <= x + w - 1; j++) {
				for (int k = y; k <= y + h - 1; k++) {
					matrix[1000 - k][j] = cnt;
				}
			}
			cnt++;
		}
		for (int num = 1; num <= N; num++) {
			int cnt1 = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if (matrix[i][j] == num) {
						cnt1++;
					}

				}
			}
			System.out.println(cnt1);
		}

	}

}
