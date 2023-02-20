import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();

			// 카운팅 배열
			int[] count = new int[10];

			int k = 0; // n에 곱해줄 수 -> 하나씩 늘어간다.

			while (true) {

				// count 배열에 0이 하나라도 있으면 계속 돌리고, 0이 하나도 없으면 멈춤!
				boolean flag = false;
				for (int i = 0; i < 10; i++) {
					if (count[i] == 0) {
						flag = true;
						break;
					}
				}

				if (flag == false) {
					break;
				}

				k++;

				int nn;
				nn = n * k; // n에 k를 곱해서 만들어지는 새로운 수.

				String num = String.valueOf(nn); // 숫자를 문자열로 바꾼다.
				// 1234 -> "1234"

				char[] arr = new char[num.length()]; // 숫자의 길이만큼의 어레이 만듦.

				arr = num.toCharArray(); // 숫자가 하나하나 들어간 어레이가 만들어짐.

				// 나온 숫자를 카운팅 배열로 넣어준다.
				for (int i = 0; i < arr.length; i++) {
					count[arr[i] - '0']++;
				}

			}
			System.out.println("#" + tc + " " + n * k);

		}
	}
}