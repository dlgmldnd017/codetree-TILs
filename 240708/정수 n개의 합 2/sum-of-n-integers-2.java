import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        int p[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        p[0] = arr[0];

        for(int i=1; i<n; i++){
            p[i] = arr[i] + p[i-1];
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n-k; i++){
            int x = p[k-1+i] - p[i] + arr[i];

            max = Math.max(max, x);
        }
        
        System.out.println(max);
    }
}