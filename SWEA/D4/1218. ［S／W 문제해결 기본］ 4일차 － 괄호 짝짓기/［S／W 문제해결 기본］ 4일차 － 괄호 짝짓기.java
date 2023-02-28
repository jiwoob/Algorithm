import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			String str = br.readLine();

			Stack<Character> st = new Stack<>();

			for (int i = 0; i < N; i++) {
				if (st.isEmpty() == true) {
					st.push(str.charAt(i));
				} else {
					if (st.peek() == '(' && str.charAt(i) == ')') {
						st.pop();
					} else if (st.peek() == '[' && str.charAt(i) == ']') {
						st.pop();
					} else if (st.peek() == '{' && str.charAt(i) == '}') {
						st.pop();
					} else if (st.peek() == '<' && str.charAt(i) == '>') {
						st.pop();
					} else {
						st.push(str.charAt(i));
					}
				}
			}

			if (st.isEmpty() == true) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);

			}

		}

	}
}