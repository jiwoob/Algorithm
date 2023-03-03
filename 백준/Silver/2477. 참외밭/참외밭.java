import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();

		int[] dir = new int[6];
		int[] len = new int[6];

		for (int i = 0; i < 6; i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}

		int[] cnt = new int[5];

		for (int i = 0; i < 6; i++) {
			cnt[dir[i]]++;
		}

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			if (cnt[i] == 1) {
				list1.add(i);
			} else if (cnt[i] == 2) {
				list2.add(i);
			}
		}

		// 한번 나온 방향
		int a = list1.get(0);
		int b = list1.get(1);

		// 두번 나온 방향
		int c = list2.get(0);
		int d = list2.get(1);

		// 작은 사각형 두변의 길이
		ArrayList<Integer> list3 = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			if (dir[i] == c || dir[i] == d) {
				if (i - 1 >= 0) {
					if ((dir[(i + 1) % 6] == c || dir[(i + 1) % 6] == d) && (dir[i - 1] == c || dir[i - 1] == d)) {
						list3.add(len[i]);
					}
				} else if (i == 0) {
					if ((dir[(i + 1) % 6] == c || dir[(i + 1) % 6] == d) && (dir[5] == c || dir[5] == d)) {
						list3.add(len[i]);
					}
				}
			}
		}

		int wid1 = 1;
		for (int i = 0; i < 6; i++) {
			if (dir[i] == a || dir[i] == b) {
				wid1 = wid1 * len[i];
			}
		}
		int wid2 = list3.get(0) * list3.get(1);
		
		System.out.println((wid1 - wid2) * K);
	}
}