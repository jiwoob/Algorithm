
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());

			// 점 접촉.
			if ((x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4) || (x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3)) {
				System.out.println("c");
				// 겹치지 않을 때.
			} else if (x2 < x3 || x1 > x4 || y2<y3 || y1>y4) {
				System.out.println("d");
				//선분.
			} else if(x2==x3 || x1==x4 || y2==y3 || y1 == y4) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}