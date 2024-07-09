import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maxRectangleSum(grid, n));
    }

    public static int maxRectangleSum(int[][] grid, int n) {
        int maxSum = Integer.MIN_VALUE;

        for (int top = 0; top < n; top++) {
            int[] temp = new int[n];

            for (int bottom = top; bottom < n; bottom++) {
                for (int col = 0; col < n; col++) {
                    temp[col] += grid[bottom][col];
                }

                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }

    public static int kadane(int[] array) {
        int maxSoFar = array[0];
        int currentMax = array[0];

        for (int i = 1; i < array.length; i++) {
            currentMax = Math.max(array[i], currentMax + array[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}