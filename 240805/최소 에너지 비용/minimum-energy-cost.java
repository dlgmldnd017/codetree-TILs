import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] dist = new int[MAX_N + 1];
    public static int[] cost = new int[MAX_N + 1];
    public static int[] minCost = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 2; i <= n; i++)
            dist[i] = sc.nextInt();
        for(int i = 1; i <= n; i++)
            cost[i] = sc.nextInt();
        
        // i번째 장소로 이제 출발할 때 기준으로
        // 지금까지 왔던 장소 중
        // 에너지 1을 채우는데 필요한 비용이
        // 가장 작은 곳을 전처리로 저장합니다.
        minCost[2] = cost[1];
        for(int i = 3; i <= n; i++)
            minCost[i] = Math.min(minCost[i - 1], cost[i - 1]);
        
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            // 지금까지 왔던 장소 중 에너지 1을 채우는데 필요한 비용이
            // 가장 작은 곳에서 그만큼의 에너지를 충전합니다.
            ans += (long) minCost[i] * dist[i];
        }
        
        // 정답을 출력합니다.
        System.out.print(ans);
    }
}