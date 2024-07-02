import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(-pq.poll() + "\n");
            }
            else{
                pq.add(-x);
            }
        }
        
        System.out.println(sb);
    }
}