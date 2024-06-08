import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        solve(N, K);
    }

    static void solve(int N, int K){
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }
        
        int idx=0;
        while(!q.isEmpty()){
            idx++;
            if(idx==K) {
                idx=0;
                System.out.print(q.poll() + " ");
            }
            else q.add(q.poll()); 
        }
    }
}