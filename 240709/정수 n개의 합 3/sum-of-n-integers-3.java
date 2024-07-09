import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int S[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + arr[i][j];                
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=1; i<=n-k+1; i++){
            for(int j=1; j<=n-k+1; j++){
                int x1 = i;
                int y1 = j;

                int x2 = i+k-1;
                int y2 = j+k-1;

                int sum = S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1];

                max = Math.max(max, sum);
            }
        }
        
        System.out.println(max);
    }
}