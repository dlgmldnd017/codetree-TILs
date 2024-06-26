import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int input = Integer.parseInt(st.nextToken());

            if(map.containsKey(input)) map.put(input, map.get(input) + 1);
            else map.put(input, 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        for(int i=0; i<k; i++){
            System.out.print(pq.poll()[0] + " ");
        }
    }
}