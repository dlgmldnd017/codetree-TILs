import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        int arr[] = new int[n];


        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            arr[i] = x;
            set.add(x);
        }

        int minDiff = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            Integer x = set.ceiling(arr[i]+m);

            if(x != null) minDiff = Math.min(minDiff, x - arr[i]);
        }

        if(minDiff == Integer.MAX_VALUE) sb.append(-1);
        else sb.append(minDiff);
        
        System.out.println(sb);
    }
}