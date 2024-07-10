import java.util.*;
import java.io.*;

public class Main {
    static int N,K, arr[][], prefixSum[][];
    
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())+1;
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefixSum = new int[N][N];

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=1; i<N; i++){
            for(int j=1; j<N; j++){
                ans = Math.max(ans, solve(i, j));
            }
        }
        
        System.out.println(ans);
    }

    static int solve(int i, int j){
        int sum = 0;

        if(K==0) {
            sum = getAreaSum(i, j, i, j);
        }
        else{
            for(int k=0; k<4; k++){
                int ny = i + dy[k] * K;
                int nx = j + dx[k] * K;

                if(!inRange(ny, nx)) continue;

                sum += arr[ny][nx];
            }

            if(K==1) return sum + arr[i][j];

            if(!inRange(i-1, j-1)){
                if(!inRange(i+1, j+1)){
                    if(!inRange(i+1, j)) sum += getAreaSum(i-1, j, i, j+1);
                    else sum += getAreaSum(i, j-1, i+1, j);
                }
                else sum += getAreaSum(i, j, i+1, j+1);
            }
            else if(!inRange(i+1, j+1)) sum += getAreaSum(i-1, j-1, i, j);
            else sum += getAreaSum(i-1, j-1, i+1, j+1);
        }
        return sum;
    }

    static boolean inRange(int y, int x){
        return (y>=1&&y<N) && (x>=1&&x<N);
    }

    static int getAreaSum(int x1, int y1, int x2, int y2){
        return prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
    }
}