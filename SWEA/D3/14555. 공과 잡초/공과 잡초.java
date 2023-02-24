import java.io.IOException;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			String str = sc.next();

			str = str.replace("()", "x");
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char before = str.charAt(i);
				if (str.charAt(i) == 'x' || str.charAt(i) == '(' || str.charAt(i) == ')') {
					cnt++;
				}

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}