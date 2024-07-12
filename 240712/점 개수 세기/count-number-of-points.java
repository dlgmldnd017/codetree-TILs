import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        
        Arrays.sort(points);
        
        // 누적 합 배열 생성
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + 1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int left = lowerBound(points, a);
            int right = upperBound(points, b);
            
            int count = right - left;
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static int lowerBound(int[] points, int x) {
        int left = 0, right = points.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (points[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private static int upperBound(int[] points, int x) {
        int left = 0, right = points.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (points[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}