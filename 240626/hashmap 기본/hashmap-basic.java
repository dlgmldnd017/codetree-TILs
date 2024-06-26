import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int a=0, b=0;

            switch(command){
                case "add":
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());

                    hm.put(a, b);
                    break;
                
                case "find":
                    a = Integer.parseInt(st.nextToken());
                    
                    if(hm.containsKey(a)) System.out.println(hm.get(a));
                    else System.out.println("None");
                    break;

                case "remove":
                    a = Integer.parseInt(st.nextToken());

                    hm.remove(a);
                    break;
            }
        }
    }
}