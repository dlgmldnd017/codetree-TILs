import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A[], B[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        B = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        if(solve()) System.out.println("Yes");
        else System.out.println("No");
    }

    static boolean solve(){
        int i = 1;

        for(int j=1; j<=M; j++){
            while(i<=N && A[i] != B[j]) i++;

            if(i == N+1) return false;
            else i++;
        }

        return true;
    }
}