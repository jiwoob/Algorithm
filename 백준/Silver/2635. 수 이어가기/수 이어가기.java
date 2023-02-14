import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int max = 0;
		List<Integer> maxlist = new ArrayList<>();

		// 첫번째 숫자는 무조건 n
		// 두번째 숫자는 1~n 모든 경우 따져봐야 함.
		for (int i = 1; i <= n; i++) {
			List<Integer> list = new ArrayList<>();

			list.add(n);
			list.add(i);

			int num1 = n;
			int num2 = i;

			while (true) {
				int tmp = num1 - num2;
				if (tmp >= 0) {
					list.add(tmp);
				} else {
					break;
				}
				num1 = num2;
				num2 = tmp;
			}

			if (max < list.size()) {
				max = list.size();
				maxlist = list;
			}

		}

		System.out.println(max);
		for (int i = 0; i < maxlist.size(); i++) {
			if (i < maxlist.size() - 1)
				System.out.print(maxlist.get(i) + " ");
			else
				System.out.print(maxlist.get(i));
		}
	}

}
