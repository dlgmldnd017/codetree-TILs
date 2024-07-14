import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n, q;
    static int arr[], prefix[];

    static TreeSet<Integer> set = new TreeSet<>();
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        int cnt=1;
        for(Integer i : set){
            map.put(i, cnt++);
        }

        prefix = new int[n+1];
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + 1;
        }

        for(int Q=0; Q<q; Q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ca = map.get(a);
            int cb = map.get(b);

            sb.append(cb-ca+1+"\n");
        }

        System.out.println(sb);
    }
}