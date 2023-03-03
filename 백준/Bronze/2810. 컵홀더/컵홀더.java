import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); // 좌석수

		String str = br.readLine();

		// L의 개수 세주기
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == 'L') {
				cnt++;
			}
		}

		// 컵홀더 수 구하기
		int cup = n + 1 - (cnt / 2);

		if (n < cup) {
			System.out.println(n);
		} else {
			System.out.println(cup);
		}
	}
}