import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int width = sc.nextInt();
		int height = sc.nextInt();
		int cut = sc.nextInt();

		// 가로로 자르는 선의 숫자 list
		List<Integer> cut0 = new ArrayList<>();

		// 세로로 자르는 선의 숫자 list
		List<Integer> cut1 = new ArrayList<>();

		for (int i = 0; i < cut; i++) {

			if (sc.nextInt() == 0) {
				cut0.add(sc.nextInt());
			} else {
				cut1.add(sc.nextInt());
			}
		}

		cut0.add(height);
		cut1.add(width);
		cut0.add(0);
		cut1.add(0);

		Collections.sort(cut0, Collections.reverseOrder());
		Collections.sort(cut1, Collections.reverseOrder());
//		System.out.println(cut0);
//		System.out.println(cut1);

		// 자른 후 가로 면적들을 담는 리스트
		List<Integer> cut0after = new ArrayList<>();
		for (int i = 0; i < cut0.size() - 1; i++) {
			cut0after.add(cut0.get(i) - cut0.get(i + 1));
		}

		// 자른 후 세로 면적들을 담는 리스트
		List<Integer> cut1after = new ArrayList<>();
		for (int i = 0; i < cut1.size() - 1; i++) {
			cut1after.add(cut1.get(i) - cut1.get(i + 1));
		}

//		System.out.println(cut0after);
//		System.out.println(cut1after);

		int max0 = Collections.max(cut0after);
		int max1 = Collections.max(cut1after);

		System.out.println(max0 * max1);
	}
}