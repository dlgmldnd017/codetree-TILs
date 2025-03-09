import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, M, ans;
    static int[][] arr;
    static boolean[][] visited;
    static List<Integer> wall = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) wall.add(Integer.parseInt(st.nextToken()));

        solve();

        System.out.println(sb);
    }

    static void solve() {
        for (int t = 0; t < K; t++) {
            List<Node> list = new ArrayList<>();

            int[][] originalArr = copyArr(arr);

            int max = Integer.MIN_VALUE;

            for (int k = 0; k < 3; k++) {
                for (int i = 1; i <= 3; i++) {
                    for (int j = 1; j <= 3; j++) {
                        rotate(i, j, k);

                        int cnt = check();

                        if (max <= cnt) {
                            max = cnt;
                            list.add(new Node(i, j, k, cnt));
                        }

                        arr = copyArr(originalArr);
                    }
                }
            }

            Collections.sort(list);

            Node cur = list.get(0);

            rotate(cur.y, cur.x, cur.num);

            max = getSum();

            if (max == 0) return;
            else sb.append(max).append(" ");
        }
    }

    static void printArr() {
        for (int[] i : arr) {
            for (int j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println();
    }

    static int[][] copyArr(int[][] copy) {
        int[][] tmp = new int[5][5];

        for (int i = 0; i < 5; i++) tmp[i] = copy[i].clone();

        return tmp;
    }

    static void rotate(int y, int x, int k) {
        if (k == 0) rotate90(y - 1, x - 1);
        else if (k == 1) rotate180(y - 1, x - 1);
        else rotate270(y - 1, x - 1);
    }

    static void rotate90(int y, int x) {
        int[][] tmp = copyArr(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[y + j][x + 2 - i] = tmp[y + i][x + j];
            }
        }
    }

    static void rotate180(int y, int x) {
        int[][] tmp = copyArr(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[y + 2 - i][x + 2 - j] = tmp[y + i][x + j];
            }
        }
    }

    static void rotate270(int y, int x) {
        int[][] tmp = copyArr(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[y + 2 - j][x + i] = tmp[y + i][x + j];
            }
        }
    }

    static int check() {
        int cnt = 0;

        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j] || arr[i][j] == 0) continue;
                visited[i][j] = true;

                cnt += bfs(i, j);
            }
        }

        return cnt;
    }

    static int getSum() {
        int sum = 0;

        while (true) {
            int cnt = 0;

            visited = new boolean[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (visited[i][j] || arr[i][j] == 0) continue;
                    visited[i][j] = true;

                    cnt += bfs(i, j);
                }
            }

            if (cnt == 0) return sum;

            sum += cnt;

            if (wall.isEmpty()) return sum;

            int i = 4, j = 0;

            while (!wall.isEmpty()) {
                if (arr[i][j] == 0) arr[i][j] = wall.remove(0);

                i--;

                if (i < 0) {
                    i = 4;
                    j++;
                }

                if (j == 5) break;
            }
        }
    }

    static int bfs(int i, int j) {
        int cnt = 0;

        Queue<Node> q1 = new ArrayDeque<>();
        q1.add(new Node(i, j, arr[i][j]));

        Queue<Node> q2 = new ArrayDeque<>();
        q2.add(new Node(i, j));

        while (!q1.isEmpty()) {
            Node cur = q1.poll();

            for (int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];

                if (!inRange(ny, nx) || visited[ny][nx] || cur.num != arr[ny][nx]) continue;
                visited[ny][nx] = true;

                q1.add(new Node(ny, nx, arr[ny][nx]));
                q2.add(new Node(ny, nx));
            }
        }

        if (q2.size() > 2) {
            cnt = q2.size();

            while (!q2.isEmpty()) {
                Node cur = q2.poll();
                arr[cur.y][cur.x] = 0;
            }
        }

        return cnt;
    }

    static boolean inRange(int y, int x) {
        return (0 <= y && y < 5) && (0 <= x && x < 5);
    }
}

class Node implements Comparable<Node> {
    int y, x, num, cnt;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    Node(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }

    Node(int y, int x, int num, int cnt) {
        this.y = y;
        this.x = x;
        this.num = num;
        this.cnt = cnt;
    }

    public int compareTo(Node n) {
        if (n.cnt == this.cnt) {
            if (this.num == n.num) {
                if (this.x == n.x) return this.y - n.y;
                return this.x - n.x;
            }
            return this.num - n.num;
        }
        return n.cnt - this.cnt;
    }
}
