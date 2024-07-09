import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean exist[] = new boolean[N];
        for(int i=0; i<B; i++){
            exist[Integer.parseInt(br.readLine())] = true;
        }

        int prefixSum[] = new int[N];
        for(int i=1; i<N; i++){
            prefixSum[i] = prefixSum[i-1] + (exist[i] ? 1:0);
        }

        int min = Integer.MAX_VALUE;
        for(int i=K; i<N; i++){
            min = Math.min(min, prefixSum[i] - prefixSum[i-K]);
        }
        
        System.out.println(min);
    }
}