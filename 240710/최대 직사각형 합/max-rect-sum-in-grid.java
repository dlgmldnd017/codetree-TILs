import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n, arr[][], prefixSum[][], dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine())+1;

        arr = new int[n][n];

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        prefixSum = new int[n][n];

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }

        solve();

        System.out.println(sb);
    }

    static void solve(){
        dp = new int[n];

        int max = Integer.MIN_VALUE;

        for(int i=1; i<n; i++){
            for(int j=i; j<n; j++){
                max = Math.max(max, getMaxValue(i, j));
            }
        }

        sb.append(max);
    }

    static int getMaxValue(int x1, int x2){
        for(int i=1; i<n; i++){
            int value = getCalcPrefixSum(x1, i, x2, i);

            dp[i] = Math.max(value, dp[i-1]+value);
        }

        int max = Integer.MIN_VALUE;

        for(int i=1; i<n; i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    static int getCalcPrefixSum(int x1, int y1, int x2, int y2){
        return prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
    }
}