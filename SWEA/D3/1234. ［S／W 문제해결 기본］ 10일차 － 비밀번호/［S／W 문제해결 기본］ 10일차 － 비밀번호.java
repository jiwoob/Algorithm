import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt(); // 문자의 길이
			String str = sc.next(); // 주어진 문자열

			Stack<Character> st = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				// 스택이 비어 있으면 무조건 쌓아준다.
				if (st.isEmpty()) {
					st.push(str.charAt(i));

				} else {
					if (st.peek() == str.charAt(i)) {
						st.pop();
					} else {
						st.push(str.charAt(i));
					}

				}

			}

			// System.out.println(st.size());

			System.out.print("#" + tc + " ");
			for (int i = 0; i < st.size(); i++) {
				System.out.print(st.get(i));
			}
			System.out.println();
		}
	}
}