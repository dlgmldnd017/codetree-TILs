import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Prefix Sum 배열 생성
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = grid[i - 1][j - 1] +
                        prefixSum[i - 1][j] +
                        prefixSum[i][j - 1] -
                        prefixSum[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // 첫 번째 직사각형을 선택
        for (int r1 = 1; r1 <= n; r1++) {
            for (int c1 = 1; c1 <= m; c1++) {
                for (int r2 = r1; r2 <= n; r2++) {
                    for (int c2 = c1; c2 <= m; c2++) {
                        int sum1 = getRectSum(prefixSum, r1, c1, r2, c2);

                        // 두 번째 직사각형을 선택
                        // 직사각형이 겹치지 않도록 주의
                        // 1. 위쪽
                        for (int r3 = 1; r3 < r1; r3++) {
                            for (int c3 = 1; c3 <= m; c3++) {
                                for (int r4 = r3; r4 < r1; r4++) {
                                    for (int c4 = c3; c4 <= m; c4++) {
                                        int sum2 = getRectSum(prefixSum, r3, c3, r4, c4);
                                        maxSum = Math.max(maxSum, sum1 + sum2);
                                    }
                                }
                            }
                        }
                        // 2. 아래쪽
                        for (int r3 = r2 + 1; r3 <= n; r3++) {
                            for (int c3 = 1; c3 <= m; c3++) {
                                for (int r4 = r3; r4 <= n; r4++) {
                                    for (int c4 = c3; c4 <= m; c4++) {
                                        int sum2 = getRectSum(prefixSum, r3, c3, r4, c4);
                                        maxSum = Math.max(maxSum, sum1 + sum2);
                                    }
                                }
                            }
                        }
                        // 3. 왼쪽
                        for (int r3 = 1; r3 <= n; r3++) {
                            for (int c3 = 1; c3 < c1; c3++) {
                                for (int r4 = r3; r4 <= n; r4++) {
                                    for (int c4 = c3; c4 < c1; c4++) {
                                        int sum2 = getRectSum(prefixSum, r3, c3, r4, c4);
                                        maxSum = Math.max(maxSum, sum1 + sum2);
                                    }
                                }
                            }
                        }
                        // 4. 오른쪽
                        for (int r3 = 1; r3 <= n; r3++) {
                            for (int c3 = c2 + 1; c3 <= m; c3++) {
                                for (int r4 = r3; r4 <= n; r4++) {
                                    for (int c4 = c3; c4 <= m; c4++) {
                                        int sum2 = getRectSum(prefixSum, r3, c3, r4, c4);
                                        maxSum = Math.max(maxSum, sum1 + sum2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxSum);
    }

    private static int getRectSum(int[][] prefixSum, int r1, int c1, int r2, int c2) {
        return prefixSum[r2][c2] -
                prefixSum[r1 - 1][c2] -
                prefixSum[r2][c1 - 1] +
                prefixSum[r1 - 1][c1 - 1];
    }
}