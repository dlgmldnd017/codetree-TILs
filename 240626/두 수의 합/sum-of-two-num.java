import java.util.*;
import java.io.*;

public class Main {
    static int n, k, count=0, arr[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, 0);
        System.out.println(count);
    }

    static void solve(int depth, int sum, int idx){
        if(sum > k) return;

        if(depth==2){
            if(sum == k) count++;
            return;
        }

        for(int i=idx; i<n; i++){
            solve(depth+1, sum+arr[i], i+1);
        }
    }
}