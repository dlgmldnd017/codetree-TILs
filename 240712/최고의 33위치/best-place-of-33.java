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

        int maxCoins = 0;

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int currentCoins = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        currentCoins += grid[i + k][j + l];
                    }
                }

                if (currentCoins > maxCoins) {
                    maxCoins = currentCoins;
                }
            }
        }

        System.out.println(maxCoins);
    }
}