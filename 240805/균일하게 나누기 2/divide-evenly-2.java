import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[][] points = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        int minM = N;
        
        // 각 점을 기준으로 x=a와 y=b 후보 값 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a = points[i][0] + 1;
                int b = points[j][1] + 1;
                
                int[] quadrant = new int[4];
                
                for (int k = 0; k < N; k++) {
                    int x = points[k][0];
                    int y = points[k][1];
                    
                    if (x < a && y < b) quadrant[0]++;
                    else if (x < a && y > b) quadrant[1]++;
                    else if (x > a && y < b) quadrant[2]++;
                    else if (x > a && y > b) quadrant[3]++;
                }
                
                int maxInQuadrant = Math.max(Math.max(quadrant[0], quadrant[1]), Math.max(quadrant[2], quadrant[3]));
                minM = Math.min(minM, maxInQuadrant);
            }
        }
        
        System.out.println(minM);
    }
}