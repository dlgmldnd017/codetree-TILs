import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        TreeSet<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<k; i++){
            int x = set.last();
            sb.append(x+" ");
            set.remove(x);
        }
        
        System.out.println(sb);
    }
}