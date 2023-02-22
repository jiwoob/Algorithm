import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			String str = sc.next(); // 중위표기식으로 입력받음.
			String res = ""; // 후위표기로 바꿀 것임.

			// 후위 표기식으로 바꾸기.
			Stack<Character> s = new Stack<>();
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);

				if (c == '*') {
					if (s.isEmpty()) {
						s.push(c);
					} else if (s.peek() == '+') {
						s.push(c);
					} else if (s.peek() == '*') {
						res += s.pop();
						s.push(c);
					}

				} else if (c == '+') {
					if (s.isEmpty()) {
						s.push(c);
					} else if (s.peek() == '+') {
						res += s.pop();
						s.push(c);

					} else if (s.peek() == '*') {
						if (s.peek() == '*') {
							res += s.pop();
						}
						if (!s.isEmpty() && s.peek() == '+') {
							res += s.pop();
						}
						s.push(c);
					}
				}

				else {
					res += c;
				}
			}

			while (!s.isEmpty()) {
				res += s.pop();
			}

			// 후위 표기식을 계산하기
			Stack<Integer> s2 = new Stack<>(); // 계산 값을 넣는 스택.
			for (int i = 0; i < res.length(); i++) { // 후위표기식 길이만큼 돌리기.
				char c = res.charAt(i);

				if (c - '0' >= 0 && c - '0' <= 9) {
					s2.push(c - '0');
				} else if (c == '+') {
					int a = s2.pop();
					int b = s2.pop();
					s2.push((a + b));
				} else if (c == '*') {
					int a = s2.pop();
					int b = s2.pop();
					s2.push(a * b);
				}
			}

			System.out.println("#" + tc + " " + s2.pop());

		}
	}
}