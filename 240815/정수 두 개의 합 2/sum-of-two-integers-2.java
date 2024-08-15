import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        int left = 0;
        int right = n - 1;
        int count = 0;
        
        // 투 포인터로 가능한 쌍의 수를 계산
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum <= k) {
                // 왼쪽 포인터를 하나 증가시키면서 가능한 쌍의 수를 계산
                count += (right - left);
                left++;
            } else {
                // 합이 k보다 크면, 오른쪽 포인터를 하나 줄여서 더 작은 합을 시도
                right--;
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}