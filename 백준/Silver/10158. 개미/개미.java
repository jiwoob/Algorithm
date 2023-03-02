import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 개미
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		// 값 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st2.nextToken());
		int q = Integer.parseInt(st2.nextToken());

		int t = Integer.parseInt(br.readLine());

		// 결과값
		int x;
		int y;

		// x축
		if ((p + t) % (2 * w) > w) {
			x = (2 * w) - (p + t) % (2 * w);
		} else {
			x = (p + t) % (2 * w);
		}

		// y축
		if ((q + t) % (2 * h) > h) {
			y = (2 * h) - (q + t) % (2 * h);
		} else {
			y = (q + t) % (2 * h);
		}

		bw.write(x + " " + y);
		bw.close();
	}
}