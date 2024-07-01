import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());

            set.add(x);
            
            int leftNum = set.lower(x)==null? set.higher(x) : set.lower(x);
            int rightNum = set.higher(x)==null? set.lower(x) : set.higher(x);

            min = Math.min(min, Math.abs(x-leftNum));
            min = Math.min(min, Math.abs(x-rightNum));

            sb.append(min+"\n");
        }



        System.out.println(sb);
    }
}