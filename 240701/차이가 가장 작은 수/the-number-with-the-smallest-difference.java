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

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            set.add(x);
        }

        int x = (Math.abs(set.last())) - (Math.abs(set.first()));

        if(x>=m) sb.append(x);
        else sb.append(-1);

        System.out.println(sb);
    }
}