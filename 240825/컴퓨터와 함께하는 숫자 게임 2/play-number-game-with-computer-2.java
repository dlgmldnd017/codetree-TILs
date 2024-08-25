import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 'int' 대신 'long' 사용
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        // 최소 횟수와 최대 횟수를 초기화
        int minCount = Integer.MAX_VALUE;
        int maxCount = 0;

        for (long target = a; target <= b; target++) {
            long L = 1;
            long R = m;
            int count = 0;

            // 이진 탐색으로 횟수를 계산
            while (L <= R) {
                count++;
                long mid = (L + R) / 2;

                if (mid == target) {
                    break;
                } else if (mid < target) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

            // 최소 횟수와 최대 횟수를 갱신
            minCount = Math.min(minCount, count);
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(minCount + " " + maxCount);
    }
}