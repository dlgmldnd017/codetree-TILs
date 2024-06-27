import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int input = Integer.parseInt(st.nextToken());

            switch(command){
                case "find":
                    sb.append(set.contains(input)+"\n");
                    break;

                case "add":
                    set.add(input);
                    break;
                
                case "remove":
                    set.remove(input);
                    break;
            }
        }

        System.out.println(sb);
    }
}