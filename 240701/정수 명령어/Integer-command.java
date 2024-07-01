import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int k = Integer.parseInt(br.readLine());
            
            TreeSet<Integer> set = new TreeSet<>();

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                switch(command){
                    case "I":
                        set.add(n);
                        break;

                    case "D":
                        if(n==1){
                            if(!set.isEmpty()) set.remove(set.last());
                        }
                        else{
                            if(!set.isEmpty()) set.remove(set.first());
                        }
                        break;
                }
            }

            if(set.isEmpty()) sb.append("EMPTY\n");
            else sb.append(set.last() + " " + set.first() + "\n");
        }

        System.out.println(sb);
    }
}