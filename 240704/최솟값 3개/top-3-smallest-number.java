import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> lower = new PriorityQueue<>();
    static PriorityQueue<Integer> higher = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        long sum = 1;

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(st.nextToken());

            if(lower.size()<3){
                sum *= x;
                lower.add(-x);
                
                if(lower.size()==3) sb.append(sum+"\n");
                else sb.append("-1\n");
            }

            else{
                if((-lower.peek()) < x){
                    higher.add(x);
                }

                else{
                    int tmp = -lower.poll();
                    sum /= tmp;

                    higher.add(tmp);
                    lower.add(-x);
                    sum *= x;
                }

                sb.append(sum+"\n");
            }
        }
        
        System.out.println(sb);
    }
}