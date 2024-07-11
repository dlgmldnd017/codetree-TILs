import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, Q, arr[], prefix1[], prefix2[], prefix3[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        prefix1 = new int[N+1];
        prefix2 = new int[N+1];
        prefix3 = new int[N+1];

        for(int i=1; i<=N; i++){
            prefix1[i] = prefix1[i-1] + (arr[i]==1?1:0);
        }

        for(int i=1; i<=N; i++){
            prefix2[i] = prefix2[i-1] + (arr[i]==2?1:0);
        }

        for(int i=1; i<=N; i++){
            prefix3[i] = prefix3[i-1] + (arr[i]==3?1:0);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(prefix1[y]-prefix1[x-1] + " ");
            sb.append(prefix2[y]-prefix2[x-1] + " ");
            sb.append(prefix3[y]-prefix3[x-1] + "\n");
        }

        System.out.println(sb);
    }
}