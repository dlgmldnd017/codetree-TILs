import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int Q = Integer.parseInt(st.nextToken());

        int tmp[] = new int[N];
        int max = Integer.MIN_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp[i]);
        }

        max++;

        boolean isExist[] = new boolean[max];
        for(int i=1; i<N; i++){
            isExist[tmp[i]] = true;
        }

        int prefix[] = new int[max];
        for(int i=1; i<max; i++){
            prefix[i] = prefix[i-1] + (isExist[i]?1:0);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A>=max) sb.append("0\n");
            else if(B>=max)sb.append(prefix[max-1] - prefix[A-1] + "\n");
            else if(A==0) sb.append(prefix[B]+"\n");
            else sb.append(prefix[B]-prefix[A-1]+"\n");
        }

        System.out.println(sb);
    }
}