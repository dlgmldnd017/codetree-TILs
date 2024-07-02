import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int x;

            switch(command){
                case "push":
                    x = Integer.parseInt(st.nextToken());
                    pq.add(-x);
                    break;

                case "pop":
                    sb.append(-pq.poll()+"\n");
                    break;

                case "size":
                    sb.append(pq.size()+"\n");
                    break;
                
                case "empty":
                    if(pq.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;

                case "top":
                    sb.append(-pq.peek()+"\n");
                    break;
            }
        }
        
        System.out.println(sb);
    }
}