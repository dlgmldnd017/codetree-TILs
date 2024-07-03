import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine())+1;

        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];

        // 누적합 
        int prefix[] = new int[N];
        
        for(int i=1; i<N; i++){
            int x = Integer.parseInt(st.nextToken());

            arr[i] = x;
            prefix[i] = prefix[i-1] + x;
        }

        // 최솟값
        int postfix[] = new int[N];
        int tmp = Integer.MAX_VALUE;

        for(int i=N-1; i>0; i--){
            tmp = Math.min(tmp, arr[i]);
            postfix[i] = tmp;
        }

        int total = prefix[N-1];
        double ans = 0.0;

        for(int K=1; K<N-2; K++){
            int sum = total - prefix[K] - postfix[K+1];

            ans = Math.max(ans, (double)sum/(N-K-2));
        }

        System.out.printf("%.2f", ans);
    }
}