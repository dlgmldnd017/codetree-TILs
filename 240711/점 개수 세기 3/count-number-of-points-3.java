import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            treeMap.put(Integer.parseInt(st.nextToken()), i);
        }

        for(int Q=0; Q<q; Q++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ceilingCnt = treeMap.get(treeMap.ceilingKey(x)) == null ? 0 : treeMap.get(treeMap.ceilingKey(y));
            int floorCnt = treeMap.get(treeMap.floorKey(y)) == null ? 0 : treeMap.get(treeMap.floorKey(x));

            sb.append(ceilingCnt-floorCnt+1+"\n");
        }

        System.out.println(sb);
    }
}