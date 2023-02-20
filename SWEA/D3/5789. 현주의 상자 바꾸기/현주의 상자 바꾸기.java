import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];

			int Q = Integer.parseInt(st.nextToken());

			for (int q = 1; q <= Q; q++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());

				int L = Integer.parseInt(st2.nextToken());
				int R = Integer.parseInt(st2.nextToken());

				for (int i = L - 1; i <= R - 1; i++) {
					arr[i] = q;
				}

			}

			System.out.print("#" + tc + " ");

			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

	}
}