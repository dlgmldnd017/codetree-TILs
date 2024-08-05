import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        
        // 누적 합 배열과 나머지 배열을 준비
        int[] prefixSums = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        
        int maxLen = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // 나머지 배열을 계산
        for (int i = 0; i <= N; i++) {
            int remainder = prefixSums[i] % 7;
            if (remainder < 0) remainder += 7;
            
            if (remainderMap.containsKey(remainder)) {
                int prevIndex = remainderMap.get(remainder);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                remainderMap.put(remainder, i);
            }
        }
        
        System.out.println(maxLen);
    }
}