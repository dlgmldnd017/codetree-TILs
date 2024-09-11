import java.util.*;
import java.io.*;

public class Main {
    static int M, N, ans;
    static int map[][];
    static List<int[]> paintedPos = new ArrayList<>();

    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) paintedPos.add(new int[]{i, j});
            }
        }

        solve();

        System.out.println(ans);
    }

    static void solve() {
        int left = 0, right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canConnect(mid)) {
                ans = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    static boolean canConnect(int D) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[M][N];

        int[] start = paintedPos.get(0);
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!inRange(nx, ny) || visited[nx][ny]) continue;

                if (Math.abs(map[nx][ny] - map[x][y]) <= D) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for (int[] pos : paintedPos) {
            if (!visited[pos[0]][pos[1]]) {
                return false;
            }
        }

        return true;
    }

    static boolean inRange(int x, int y){
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}