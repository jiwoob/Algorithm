import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String str = sc.next();

			char[] arr = new char[str.length()];

			arr = str.toCharArray();

			char[] arr2 = new char[str.length()];

			int res = 1;
			for (int j = 0; j < str.length() / 2; j++) {
				if (arr[j] != arr[arr.length - j - 1]) {
					res = 0;
					break;
				}
			}
			System.out.println("#" + tc + " " + res);

		}
	}
}