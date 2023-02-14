import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int[] arr = new int[str.length()];

			// 스트링으로 받아온 값을 인트 배열로 만들어준다.
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.toCharArray()[i] - '0';
			}

			// 현재 박수 치고 있는 사람의 수
			int current = 0;
			// 고용해야 하는 사람의 수
			int people = 0;

			for (int i = 0; i < arr.length; i++) {
				if (current >= i) {
					current += arr[i];
				} else {
					int peopletmp = 0;
					people += (i - current);
					peopletmp += (i - current);
					current += peopletmp;
					current += arr[i];
				}
			}
			System.out.println("#" + tc + " " + people);

		}

	}
}