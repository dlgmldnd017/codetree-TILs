import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 장소의 개수
        int n = sc.nextInt();
        
        // 장소와 장소 사이의 이동 에너지
        int[] moveEnergy = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            moveEnergy[i] = sc.nextInt();
        }
        
        // 각 장소마다 에너지 1을 채우는데 드는 비용
        int[] fillCost = new int[n];
        for (int i = 0; i < n; i++) {
            fillCost[i] = sc.nextInt();
        }
        
        // 최소 비용 계산
        long minCost = 0;
        long currentMinCost = fillCost[0];
        
        for (int i = 0; i < n - 1; i++) {
            minCost += currentMinCost * moveEnergy[i];
            if (fillCost[i + 1] < currentMinCost) {
                currentMinCost = fillCost[i + 1];
            }
        }
        
        System.out.println(minCost);
    }
}