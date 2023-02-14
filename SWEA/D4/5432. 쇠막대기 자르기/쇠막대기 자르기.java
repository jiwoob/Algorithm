import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			str = str.replace("()", "1");

			
			// 쇠막대기의 개수
			int stick = 0;

			// 잘린 후 쇠막대기 조각의 개수
			int pcs = 0;

			// 전체 길이만큼 돌린다.
			for (int i = 0; i < str.length(); i++) {

				// 레이저를 만나면, 막대 -> 조각에 더함
				if (str.charAt(i) == '1') {
					pcs += stick;
				}

				// "(" 얘를 만나면 쇠막대기의 개수 추가
				else if (str.charAt(i) == '(') {
					stick++;
				}

				// ")" 얘를 만나면 기존 쇠막대기 개수만큼 더했다가 겹치는 만큼 다시 빼줌.
				else {
					pcs += stick; // 잘린거 말고 본체 막대기의 개수 더함.
					stick--; // 막대기 하나가 닫힌거니까 개수 하나 줄어듦.
					pcs -= stick; // 중복 제거
				}

			}

			System.out.println("#" + tc + " " + pcs);

		}
	}
}