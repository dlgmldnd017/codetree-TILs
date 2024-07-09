import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int B = sc.nextInt();
        
        // 고장난 신호등 위치를 저장할 배열
        boolean[] broken = new boolean[N + 1];
        
        for (int i = 0; i < B; i++) {
            int brokenPosition = sc.nextInt();
            broken[brokenPosition] = true;
        }
        
        // 누적합 배열
        int[] prefixSum = new int[N + 1];
        
        // 누적합 배열을 채운다
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + (broken[i] ? 1 : 0);
        }
        
        // 최소로 고쳐야 할 신호등 수를 찾는다
        int minToFix = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            int brokenInWindow = prefixSum[i] - prefixSum[i - K];
            minToFix = Math.min(minToFix, brokenInWindow);
        }
        
        System.out.println(minToFix);
    }
}