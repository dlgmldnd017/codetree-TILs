import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] L = new int[n];
        int[] R = new int[n];
        
        L[0] = points[0][1] - points[0][0];
        R[n - 1] = points[n - 1][1] - points[n - 1][0];
        
        for (int i = 1; i < n; i++) {
            if (isOverlap(points[i - 1], points[i])) {
                L[i] = L[i - 1] + points[i][1] - points[i - 1][1];
            } else {
                L[i] = L[i - 1] + points[i][1] - points[i][0];
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            if (isOverlap(points[i], points[i + 1])) {
                R[i] = R[i + 1] + points[i + 1][0] - points[i][0];
            } else {
                R[i] = R[i + 1] + points[i][1] - points[i][0];
            }
        }
        
        int ans = -1;
        
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, L[i - 1] + R[i + 1]);
        }
        
        ans = Math.max(ans, R[1]);
        ans = Math.max(ans, L[n - 2]);
        
        System.out.println(ans);
    }
    
    public static boolean isOverlap(int[] p1, int[] p2) {
        int s1 = p1[0], e1 = p1[1];
        int s2 = p2[0], e2 = p2[1];
        return e1 > s2;
    }
}