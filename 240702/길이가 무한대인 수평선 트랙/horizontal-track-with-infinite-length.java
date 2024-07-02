import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            long goal = T*v + l;

            if(set.ceiling(goal)==null){
                set.add(goal);
            }
            else{
                while(set.ceiling(goal)!=null){
                    set.remove(set.ceiling(goal));
                }

                set.add(goal);
            }
        }
        
        System.out.println(set.size());
    }
}