import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] bingo = new int[5][5]; // 나의 빙고판.
	static int line = 0; // 완성된 빙고 줄 개수.
	static int[] nums = new int[25];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				nums[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}

		int call = 0; // 부르는 숫자 개수.

		int num; // 부르는 숫자 입력 받을 변수..
		for (int N = 0; N < 25; N++) {
			num = nums[N];

			// System.out.println(num);
			// 부르는 숫자 하나마다, 빙고판에서 찾아야됨
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (bingo[i][j] == num)
						bingo[i][j] = 0;
				}
			}

			// 숫자 하나씩 부를 때마다. 빙고 가로 세로 대각선 완성 되었는지 체크.
			checkRow();
			checkCol();
			checkDia1();
			checkDia2();

			// 숫자 하나씩 부를 때마다.
			call++;

			// 줄이 3개 이상 만들어지면 for - end!!
			if (line >= 3) {
				System.out.println(call);
				break;
			}
			line = 0;
		}

	}

	public static void checkRow() {
		for (int i = 0; i < 5; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				tmp += bingo[i][j];
			}
			if (tmp == 0)
				line++;
		}
	}

	public static void checkCol() {
		for (int i = 0; i < 5; i++) {
			int tmp = 0;
			for (int j = 0; j < 5; j++) {
				tmp += bingo[j][i];
			}
			if (tmp == 0)
				line++;
		}
	}

	// 방법1
	public static void checkDia1() {
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			// int tmp = 0;
			int j = i;
//			for (int j = i; j <= i; j++) {
			// tmp += bingo[i][j];
			if (bingo[i][j] != 0) {
				flag = true;
			}

//			}
//			if (tmp == 0)
//				line++;
		}
		if (!flag) {
			++line;
		}
	}

	// 방법2
	public static void checkDia2() {
		int tmp = 0;

		for (int i = 0; i < 5; i++) {
			tmp += bingo[i][5 - i - 1];
		}
		if (tmp == 0)
			line++;
	}
}