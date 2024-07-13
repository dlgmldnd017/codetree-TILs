import java.util.*;
import java.io.*;

public class Main {
    static int n, m, ans;
    static int arr[][];

    static int dy[][] = {
        {0, 0, -1}, // ㄴ
        {0, 0, 1}, // ㄱ
        {0, -1, 0},
        {0, 0, 1},
        {0, 0, 0},
        {-1, 0, 1}
    };

    static int dx[][] = {
        {0, 1, 0}, //ㄴ
        {0, -1, 0}, //ㄱ
        {0, 0, -1},
        {0, 1, 0},
        {-1, 0, 1},
        {0, 0, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                solve(i, j);
            }
        }

        System.out.println(ans);
    }

    static void solve(int y, int x){
        for(int k=0; k<6; k++){
            int sum = 0;
            boolean isTrue = true;

            for(int i=0; i<3; i++){
                int ny = dy[k][i] + y;
                int nx = dx[k][i] + x;

                if(!inRange(ny, nx)) {
                    isTrue = false;
                    break;
                }
                sum += arr[ny][nx];
            }

            // if(y==1 && x==0) System.out.println(sum);

            if(isTrue) ans = Math.max(ans, sum);
        }       
    }

    static boolean inRange(int y, int x){
        return (y>=0&&y<n) && (x>=0&&x<m);
    }
}