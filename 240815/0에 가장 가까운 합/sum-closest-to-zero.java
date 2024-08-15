import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        int left = 0;
        int right = n - 1;
        int closestSum = Integer.MAX_VALUE;
        
        // 투 포인터로 0에 가장 가까운 합 찾기
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // 현재 합이 0에 더 가까운지 확인
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
            }
            
            // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                // 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로
                left++;
            } else {
                // 합이 정확히 0이면 더 가까운 값이 없으므로 종료
                break;
            }
        }
        
        // 절대값을 출력
        System.out.println(Math.abs(closestSum));
    }
}