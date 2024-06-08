import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N =  Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            String command = "";
            int input = 0;

            if(st.countTokens()==2){
                command = st.nextToken();
                input = Integer.parseInt(st.nextToken());
            }

            else{
                command = st.nextToken();
            }

            switch(command){
                case "push":
                    q.add(input);
                    break;
                
                case "pop":
                    System.out.println(q.poll());
                    break;
                
                case "size":
                    System.out.println(q.size());
                    break;
                
                case "empty":
                    if(q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                
                case "front":
                    System.out.println(q.peek());
                    break;
            }
        }
    }
}