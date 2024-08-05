import java.util.Scanner;
import java.util.Arrays;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;        // x 기준 오름차순 정렬
    }
}

public class Main {    
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_Q = 4;
    public static final int MAX_R = 1000;
    public static final int MAX_N = 1000;
    
    // 변수 선언
    public static int n;
    public static Point[] points = new Point[MAX_N];
    
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        // x 기준 오름차순으로 정렬합니다.
        Arrays.sort(points, 0, n);

        // y = b를 먼저 설정합니다.
        for(int b = 0; b <= MAX_R; b += 2) {
            // 1, 2, 3, 4 각 사분면에 
            // 들어 있는 점의 개수를 관리합니다.
            int[] cnt = new int[MAX_Q + 1];

            // 먼저 x = 0일 때의
            // 1, 2, 3, 4 각 사분면에
            // 있는 점의 수를 계산합니다. 
            // 모든 점은 x = 0 보다 오른쪽에 있으므로
            // 이는 y좌표에 따라 1, 4 사분면으로 나뉘게 됩니다.
            for(int i = 0; i < n; i++) {
                if(points[i].y > b)
                    cnt[1]++;
                else
                    cnt[4]++;
            }

            // 이제 x 기준 오름차순으로 정렬된 
            // n개의 점을 보며 
            // 각 점을 순서대로 왼쪽으로 보내며
            // 1 -> 2 사분면으로
            // 4 -> 3 사분면으로 점들의 위치를 보정해줍니다.
            for(int i = 0; i < n; i++) {
                // 새로운 x값이 시작되는 경우에는
                // 답을 갱신해줍니다.
                if(i == 0 || points[i].x != points[i - 1].x) {
                    int maxCnt = 0;
                    for(int j = 1; j <= MAX_Q; j++)
                        maxCnt = Math.max(maxCnt, cnt[j]);
                    
                    ans = Math.min(ans, maxCnt);
                }
            
                // i번 점의 위치를 보정해줍니다.
                if(points[i].y > b) {
                    cnt[1]--;
                    cnt[2]++;
                }
                else {
                    cnt[4]--;
                    cnt[3]++;
                }
            }
        }
        System.out.print(ans);
    }
}