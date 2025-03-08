import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, F, cnt, ans;
    static int[][] us;
    static int[][][] ts;
    static Node[][] tw;

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        tw = new Node[M][M];

        us = new int[N][N];

        int row = 0, col = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                us[i][j] = -Integer.parseInt(st.nextToken());

                if (us[i][j] == -3) {
                    tw[row][col] = new Node(i, j);
                    col++;

                    if (col == M) {
                        row++;
                        col = 0;
                    }
                }
            }
        }

        ts = new int[5][M][M];

        int startY = -1, startX = -1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    ts[i][j][k] = Integer.parseInt(st.nextToken());

                    if (ts[i][j][k] == 2) {
                        startY = j;
                        startX = k;
                    }
                }
            }
        }

        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            us[y][x] = v;

            int inc = v;

            while (true) {
                y += dy[d];
                x += dx[d];

                if (!USInRange(y, x) || us[y][x] != 0) break;

                us[y][x] = v;
                v += inc;
            }
        }

        solve(startY, startX);

        System.out.println(ans == 0 ? -1 : ans);
    }

    static void solve(int startY, int startX) {
        PriorityQueue<TM> pq = new PriorityQueue<>();
        pq.add(new TM(startY, startX, 4, 0));

        boolean[][][] visited = new boolean[6][N][N];
        visited[4][startY][startX] = true;

        while (!pq.isEmpty()) {
            TM cur = pq.poll();

            for (int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];

                if (cur.d != 5) {
                    int dir = cur.d;

                    if (!TSInRange(ny, nx)) {

                        switch (cur.d) {
                            // 위면일 경우
                            case 4:
                                if (k == 0) {
                                    ny = 0;
                                    nx = M - cur.y - 1;
                                    dir = 0;
                                } else if (k == 1) {
                                    ny = 0;
                                    nx = cur.y;
                                    dir = 1;
                                } else if (k == 2) {
                                    ny = 0;
                                    dir = 2;
                                } else {
                                    ny = 0;
                                    nx = M - cur.x - 1;
                                    dir = 3;
                                }
                                break;

                            // 동쪽일 경우
                            case 0:
                                if (k == 0) {
                                    nx = 0;
                                    dir = 3;
                                } else if (k == 1) {
                                    nx = M - 1;
                                    dir = 1;
                                } else if (k == 3) {
                                    ny = M - nx - 1;
                                    nx = M - 1;
                                    dir = 4;
                                } else {
                                    ny = tw[cur.y - cur.x][M - 1].y + dy[0];
                                    nx = tw[cur.y - cur.x][M - 1].x + dx[0];
                                    dir = 5;

                                    if (USInRange(ny, nx) && !visited[dir][ny][nx] & (us[ny][nx] == 0 || us[ny][nx] > cur.t + 1 )) {
                                        visited[dir][ny][nx] = true;
                                        pq.add(new TM(ny, nx, dir, cur.t + 1));
                                    }
                                    continue;
                                }
                                break;

                            // 서쪽일 경우
                            case 1:
                                if (k == 0) {
                                    nx = 0;
                                    dir = 2;
                                } else if (k == 1) {
                                    nx = M - 1;
                                    dir = 3;
                                } else if (k == 3) {
                                    ny = cur.x;
                                    nx = cur.y;
                                    dir = 4;
                                } else {
                                    ny = tw[cur.x][0].y + dy[1];
                                    nx = tw[cur.x][0].x + dx[1];
                                    dir = 5;

                                    if (USInRange(ny, nx) && !visited[dir][ny][nx] & (us[ny][nx] == 0 || us[ny][nx] > cur.t + 1 )) {
                                        visited[dir][ny][nx] = true;
                                        pq.add(new TM(ny, nx, dir, cur.t + 1));
                                    }
                                    continue;
                                }
                                break;

                            // 남쪽일 경우
                            case 2:
                                if (k == 0) {
                                    nx = 0;
                                    dir = 0;
                                } else if (k == 1) {
                                    nx = M - 1;
                                    dir = 1;
                                } else if (k == 3) {
                                    ny = M - 1;
                                    dir = 4;
                                } else {
                                    ny = tw[cur.y][cur.x].y + dy[2];
                                    nx = tw[cur.y][cur.x].x + dx[2];
                                    dir = 5;

                                    if (USInRange(ny, nx) && !visited[dir][ny][nx] & (us[ny][nx] == 0 || us[ny][nx] > cur.t + 1 )) {
                                        visited[dir][ny][nx] = true;
                                        pq.add(new TM(ny, nx, dir, cur.t + 1));
                                    }
                                    continue;
                                }
                                break;

                            // 북쪽일 경우
                            case 3:
                                if (k == 0) {
                                    nx = 0;
                                    dir = 1;
                                } else if (k == 1) {
                                    nx = M - 1;
                                    dir = 1;
                                } else if (k == 3) {
                                    ny = 0;
                                    nx = M - cur.x - 1;
                                    dir = 4;
                                } else {
                                    ny = tw[0][M - cur.x - 1].y + dy[3];
                                    nx = tw[0][M - cur.x - 1].x + dx[3];
                                    dir = 5;

                                    if (USInRange(ny, nx) && !visited[dir][ny][nx] & (us[ny][nx] == 0 || us[ny][nx] > cur.t + 1 )) {
                                        visited[dir][ny][nx] = true;
                                        pq.add(new TM(ny, nx, dir, cur.t + 1));
                                    }
                                    continue;
                                }
                                break;
                        }
                    }

                    if (visited[dir][ny][nx] || ts[dir][ny][nx] == 1) continue;
                    visited[dir][ny][nx] = true;
                    pq.add(new TM(ny, nx, dir, cur.t + 1));
                } else if (!USInRange(ny, nx)) continue;
                else if (us[ny][nx] == -4) {
                    ans = cur.t + 1;
                    return;
                } else if (!visited[cur.d][ny][nx] &&(us[ny][nx] == 0 || us[ny][nx] > cur.t + 1)) {
                    visited[cur.d][ny][nx] = true;
                    pq.add(new TM(ny, nx, cur.d, cur.t + 1));
                }
            }
        }
    }

    static boolean TSInRange(int y, int x) {
        return (0 <= y && y < M) && (0 <= x && x < M);
    }

    static boolean USInRange(int y, int x) {
        return (0 <= y && y < N) && (0 <= x && x < N);
    }
}

class TM implements Comparable<TM> {
    int y, x, d, t;

    TM(int y, int x, int d, int t) {
        this.y = y;
        this.x = x;
        this.d = d;
        this.t = t;
    }

    public int compareTo(TM T) {
        return this.t - T.t;
    }
}

class Node {
    int y, x;

    Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}