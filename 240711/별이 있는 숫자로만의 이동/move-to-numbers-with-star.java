import java.util.Scanner;

public class Main {
    public static final int MAX_N = 400;
    
    // 변수 선언
    public static int n, k;
    public static int[][] board = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] s = new int[MAX_N + 1][MAX_N + 1];
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) board[i][j] = sc.nextInt();

        // 배열의 누적합을 구합니다.
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                s[i][j] = s[i][j-1] + board[i][j];
        
        // 모든 중심에 대해 최댓값을 구합니다.
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) {
                // 중심이 (i, j)일 때의 숫자 합을 구합니다.
                int sumAll = 0;
                for(int r = i - k; r <= i + k; r++) {
                    // r행일때 (j - c ~ j + c)열 까지의 부분합을 더해줍니다.
                    int c = k - Math.abs(i - r);

                    // r행이 범위 안에 있을 경우 부분합을 더해줍니다.
                    if(1 <= r && r <= n)
                        sumAll += s[r][Math.min(j + c, n)] - s[r][Math.max(j - c - 1, 0)];
                }
                
                ans = Math.max(ans, sumAll);
            }
        
        // 정답을 출력합니다.
        System.out.print(ans);
    }
}