import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String input = br.readLine();

            char[] charArray = input.toCharArray();
            Arrays.sort(charArray);

            String str = new String(charArray);

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
            return b[1] - a[1];
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getKey().hashCode(), entry.getValue()});
        }

        System.out.println(pq.poll()[1]);
    }
}