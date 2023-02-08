import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//숫자배열회
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			// test 케이스 개수 당 하나 어레이 만들 것.

			int[][] arr = new int[n][n];

			// set numbers in array
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			List<String> list = new ArrayList<>();
			
			// rotate 90
			int[][] arr90 = new int[n][n];
			for (int j = 0; j < n; j++) {
				String str = "";
				for (int i = (n - 1); i >= 0; i--) {
					str += arr[i][j];
				}
				list.add(str);
			}

			// rotate 180
			int[][] arr180 = new int[n][n];
			for (int i = (n - 1); i >= 0; i--) {
				String str ="";
				for (int j = (n - 1); j >= 0; j--) {
					str += arr[i][j];
				}
				list.add(str);
			}

			// rotate 270
			int[][] arr270 = new int[n][n];
			for (int j = (n - 1); j >= 0; j--) {
				String str ="";

				for (int i = 0; i < n; i++) {
					str += arr[i][j];
				}
				list.add(str);
			}
			
			
							System.out.println("#"+tc);	

			for(int i =0; i< n; i++) {
				System.out.println(list.get(i) + " "+list.get(i+n) +" " +list.get(i+2*n));
			}
			
			
			
//			// print
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.println(arr90[i][j]);
//				}
//			}

		}
	}
}