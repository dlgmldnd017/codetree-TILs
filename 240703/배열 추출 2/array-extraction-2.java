import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> minus = new PriorityQueue<>();
        PriorityQueue<Long> plus = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            long x = Long.parseLong(br.readLine());

            if(x==0){
                if(minus.isEmpty() && plus.isEmpty()) sb.append("0\n");
                else {
                    long m = minus.isEmpty() ? 0 : minus.poll();
                    long p = plus.isEmpty() ? 0 : plus.poll();

                    if(m==0){
                        sb.append(p + "\n");
                    }

                    else if(p==0){
                        sb.append(m + "\n");
                    }

                    else{

                        if(m>p){
                            sb.append(p+"\n");
                            minus.add(m);    
                        }

                        else{
                            sb.append(-m+"\n");
                            plus.add(p);
                        }
                    }
                }
            }

            else{
                if(x>=0){
                    plus.add(x);
                }

                else{
                    minus.add(-x);
                }
            }
        }
        
        System.out.println(sb);
    }
}