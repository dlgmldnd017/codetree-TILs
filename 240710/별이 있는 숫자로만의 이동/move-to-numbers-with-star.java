import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] grid;
    static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // 누적합 배열 계산
        prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = grid[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        int maxSum = 0;
        // 각 위치에서 K칸 이내의 합 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = getSum(i, j, K);
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);
    }

    static int getSum(int x, int y, int k) {
        int sum = 0;
        for (int i = Math.max(0, x - k); i <= Math.min(N - 1, x + k); i++) {
            int remK = k - Math.abs(x - i);
            int left = Math.max(0, y - remK);
            int right = Math.min(N - 1, y + remK);
            sum += getRangeSum(i, left, right);
        }
        return sum;
    }

    static int getRangeSum(int row, int left, int right) {
        return prefixSum[row + 1][right + 1] - prefixSum[row + 1][left] - prefixSum[row][right + 1] + prefixSum[row][left];
    }
}