import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 누적합 배열 생성
        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = grid[i - 1][j - 1]
                                + prefixSum[i - 1][j]
                                + prefixSum[i][j - 1]
                                - prefixSum[i - 1][j - 1];
            }
        }

        int maxSum = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 모든 시작점을 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                boolean[][] visited = new boolean[N][N];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j, 0});
                visited[i][j] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0], y = cur[1], dist = cur[2];
                    sum += grid[x][y];

                    if (dist < K) {
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny, dist + 1});
                            }
                        }
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
        }

        System.out.println(maxSum);
    }
}