import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] checkpoints = new int[n][2];

        for (int i = 0; i < n; i++) {
            checkpoints[i][0] = sc.nextInt();
            checkpoints[i][1] = sc.nextInt();
        }

        // 총 거리 계산
        int totalDistance = 0;
        for (int i = 1; i < n; i++) {
            totalDistance += Math.abs(checkpoints[i][0] - checkpoints[i - 1][0])
                    + Math.abs(checkpoints[i][1] - checkpoints[i - 1][1]);
        }

        // 한 개의 체크포인트를 건너뛸 때의 최소 거리 계산
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int skipDistance = totalDistance
                    - (Math.abs(checkpoints[i][0] - checkpoints[i - 1][0])
                    + Math.abs(checkpoints[i][1] - checkpoints[i - 1][1]))
                    - (Math.abs(checkpoints[i + 1][0] - checkpoints[i][0])
                    + Math.abs(checkpoints[i + 1][1] - checkpoints[i][1]))
                    + (Math.abs(checkpoints[i + 1][0] - checkpoints[i - 1][0])
                    + Math.abs(checkpoints[i + 1][1] - checkpoints[i - 1][1]));
            minDistance = Math.min(minDistance, skipDistance);
        }

        System.out.println(minDistance);
    }
}