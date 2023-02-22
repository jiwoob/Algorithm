import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[] arr = new String[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = st.nextToken();
			}

			String[] res = new String[n];

			for (int i = 0; i < n; i++) {
				if (n % 2 == 0) {
					if (i < n / 2) {
						res[i * 2] = arr[i];
					} else {
						res[(i - n / 2) * 2 + 1] = arr[i];
					}
				} else {
					if (i <= n / 2) {
						res[i * 2] = arr[i];
					} else {
						res[(i - n / 2 - 1) * 2 + 1] = arr[i];
					}
				}
			}

			// print
			System.out.print("#" + tc);
			for (int i = 0; i < n; i++) {
				System.out.print(" " + res[i]);
			}
			System.out.println();

		}

	}
}