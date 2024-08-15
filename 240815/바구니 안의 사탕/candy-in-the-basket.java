import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] baskets = new int[N][2];

        for (int i = 0; i < N; i++) {
            baskets[i][0] = scanner.nextInt(); // 사탕의 개수
            baskets[i][1] = scanner.nextInt(); // 바구니의 위치
        }

        // 바구니 위치를 기준으로 정렬
        Arrays.sort(baskets, (a, b) -> Integer.compare(a[1], b[1]));

        int left = 0;
        int right = 0;
        int currentCandies = 0;
        int maxCandies = 0;

        // 투 포인터로 최대 사탕 수 구하기
        while (right < N) {
            // 현재 구간 [baskets[left][1], baskets[right][1]]의 길이가 2K 이하인지 확인
            if (baskets[right][1] - baskets[left][1] <= 2 * K) {
                currentCandies += baskets[right][0];
                maxCandies = Math.max(maxCandies, currentCandies);
                right++;
            } else {
                currentCandies -= baskets[left][0];
                left++;
            }
        }

        // 결과 출력
        System.out.println(maxCandies);
    }
}