import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 최대 평균값을 저장할 변수
        double maxAverage = 0.0;
        
        // K의 범위는 1 이상 N-2 이하
        for (int K = 1; K <= N - 2; K++) {
            // 앞에서부터 K개를 삭제한 후 남은 배열
            int[] remaining = Arrays.copyOfRange(arr, K, N);
            
            // 남은 배열을 정렬
            Arrays.sort(remaining);
            
            // 가장 작은 값을 제외하고 합을 계산
            int sum = 0;
            for (int i = 1; i < remaining.length; i++) {
                sum += remaining[i];
            }
            
            // 평균 계산
            double average = (double) sum / (remaining.length - 1);
            
            // 최대 평균값 갱신
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        
        // 결과 출력 (소수점 둘째 자리까지)
        System.out.printf("%.2f\n", maxAverage);
    }
}