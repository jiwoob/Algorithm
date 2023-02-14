import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int res = 0;

		if (n % 5 == 0) {
			res = n / 5;
		} else if (n % 5 == 3) {
			res = n / 5 + 1;
		} else if (n % 5 == 4) {
			if (n >= 9)
				res = n / 5 + 2;
			else
				res = -1;
		} else if (n % 5 == 2) {
			if (n >= 12)
				res = n / 5 - 2 + 4;
			else
				res = -1;
		} else if (n % 5 == 1) {
			if (n >= 6)
				res = n / 5 + 1;
			else
				res = -1;
		}
		System.out.println(res);
	}
}