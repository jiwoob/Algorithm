import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력값 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt(); // 사람수
        
        // 코드 시작
        for (int i = 0; i < m; i++) {
            int gen = sc.nextInt(); // 성별
            int num = sc.nextInt(); // 주어진 숫자.

            if (gen == 1) { // 남자일때
                manSwap(arr, num);
            } else if (gen == 2) { // 여자일때
                womanSwap(arr, num);
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    public static void manSwap(int[] arr, int num) {
        int n = arr.length;
        for (int j = 1; j <= n / num; j++) {
            indexSwap(arr, num * j - 1);
        }
    }

    public static void womanSwap(int[] arr, int num) {
        int n = arr.length;
        indexSwap(arr, num - 1);

        for (int j = 1; j <= n / 2; j++) {
            if (0 <= num - 1 - j && num - 1 + j < n) {
                if (arr[num - 1 + j] == arr[num - 1 - j]) {
                    indexSwap(arr, num - 1 + j);
                    indexSwap(arr, num - 1 - j);
                } else {
                    break; 
                }
            }

        }
    }

    public static void indexSwap(int[] arr, int x) {
        if (arr[x] == 0) {
            arr[x] = 1;
        } else {
            arr[x] = 0;
        }
    }
}